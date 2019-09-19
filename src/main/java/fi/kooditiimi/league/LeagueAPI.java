package fi.kooditiimi.league;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LeagueAPI {

    public LeagueAPI() {
    }

    public LeagueProfile getProfileByName(String name, String server) {
        HttpResponse<String> summonerByNameRequest = makeLeagueReguest("https://" + server + ".api.riotgames.com/lol/summoner/v4/summoners/by-name/" + name);

        JSONObject summonerIdJson = new JSONObject(summonerByNameRequest.body());
        String summonerId = summonerIdJson.getString("id");
        String accountID = summonerIdJson.getString("accountId");
        String summonerName = summonerIdJson.getString("name");
        //server tässä välissä, mutta käytetään tota jo annettua
        int summonerLevel = summonerIdJson.getInt("summonerLevel");
        int profileIconId = summonerIdJson.getInt("profileIconId");

        String summonerRank = "Unranked";
        int summonerRankedWins = 0, summonerRankedLosses = 0;

        HttpResponse<String> summonerLeagueBySummonerIdRequest = makeLeagueReguest("https://" + server + ".api.riotgames.com/lol/league/v4/entries/by-summoner/" + summonerId);
        JSONArray summonerLeagueArray = new JSONArray(summonerLeagueBySummonerIdRequest.body());

        if (!summonerLeagueArray.isEmpty()) {
            for (int i = 0; i < summonerLeagueArray.length(); i++) {
                JSONObject summonerLeague = summonerLeagueArray.getJSONObject(i);
                if (summonerLeague.getString("queueType").equals("RANKED_SOLO_5x5")) {
                    summonerRank = summonerLeague.getString("tier") + " " +
                            summonerLeague.getString("rank") + " " +
                            summonerLeague.getInt("leaguePoints") + " LP";
                    summonerRankedWins = summonerLeague.getInt("wins");
                    summonerRankedLosses = summonerLeague.getInt("losses");
                    break;
                }
            }

        }

        return new LeagueProfile(summonerId, accountID, summonerName, server, summonerLevel, summonerRank, summonerRankedWins, summonerRankedLosses, profileIconId);
    }

    //Käytetään game komennon kanssa
    public LeagueProfile getInGameProfile(String summonerId, String server) {

        String summonerRank = "Unranked";
        int summonerRankedWins = 0, summonerRankedLosses = 0;

        HttpResponse<String> summonerLeagueBySummonerIdRequest = makeLeagueReguest("https://" + server + ".api.riotgames.com/lol/league/v4/entries/by-summoner/" + summonerId);
        JSONArray summonerLeagueArray = new JSONArray(summonerLeagueBySummonerIdRequest.body());

        if (!summonerLeagueArray.isEmpty()) {
            for (int i = 0; i < summonerLeagueArray.length(); i++) {
                JSONObject summonerLeague = summonerLeagueArray.getJSONObject(i);
                if (summonerLeague.getString("queueType").equals("RANKED_SOLO_5x5")) {
                    summonerRank = summonerLeague.getString("tier") + " " +
                            summonerLeague.getString("rank");
                    summonerRankedWins = summonerLeague.getInt("wins");
                    summonerRankedLosses = summonerLeague.getInt("losses");
                    break;
                }
            }
        }

        return new LeagueProfile(summonerId, server, summonerRank, summonerRankedWins, summonerRankedLosses);
    }

    //returnaa pelin sisällön JSON:ina
    public JSONObject getGame(String name, String server){

        HttpResponse<String> summonerByNameRequest = makeLeagueReguest("https://" + server + ".api.riotgames.com/lol/summoner/v4/summoners/by-name/" + name);

        JSONObject summonerIdJson = new JSONObject(summonerByNameRequest.body());

        HttpResponse<String> gameByIdRequest = makeLeagueReguest("https://" + server + ".api.riotgames.com/lol/spectator/v4/active-games/by-summoner/" + summonerIdJson.getString("id"));

        return new JSONObject(gameByIdRequest.body());
    }

    private HttpResponse<String> makeLeagueReguest(String url) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .headers("X-Riot-Token", "RGAPI-b2253d85-974c-4f52-b802-0ab50a94b1b8")
                    .build();

            return client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (Exception e) {
            System.err.println("Something is wrong with the api request: " + e);
            return null;
        }
    }
}
