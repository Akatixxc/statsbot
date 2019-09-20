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
        JSONObject summonerByNameJSON = new JSONObject(summonerByNameRequest.body());

        String summonerId = summonerByNameJSON.getString("id");
        String accountId = summonerByNameJSON.getString("accountId");
        String summonerName = summonerByNameJSON.getString("name");
        //server tässä välissä, mutta käytetään tota jo annettua
        int summonerLevel = summonerByNameJSON.getInt("summonerLevel");
        int profileIconId = summonerByNameJSON.getInt("profileIconId");

        HttpResponse<String> summonerLeagueBySummonerIdRequest = makeLeagueReguest("https://" + server + ".api.riotgames.com/lol/league/v4/entries/by-summoner/" + summonerId);
        JSONArray summonerLeagueBySummonerIdJSON = new JSONArray(summonerLeagueBySummonerIdRequest.body());

        String summonerRank = "Unranked";
        int summonerRankedWins = 0, summonerRankedLosses = 0;

        if (!summonerLeagueBySummonerIdJSON.isEmpty()) {
            for (int i = 0; i < summonerLeagueBySummonerIdJSON.length(); i++) {
                JSONObject summonerLeague = summonerLeagueBySummonerIdJSON.getJSONObject(i);
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

        return new LeagueProfile(summonerId, accountId, summonerName, server, summonerLevel, summonerRank, summonerRankedWins, summonerRankedLosses, profileIconId);
    }

    //Käytetään game komennon kanssa
    public LeagueProfile getInGameProfile(String summonerId, String server) {

        HttpResponse<String> summonerLeagueBySummonerIdRequest = makeLeagueReguest("https://" + server + ".api.riotgames.com/lol/league/v4/entries/by-summoner/" + summonerId);
        JSONArray summonerLeagueBySummonerIdJSON = new JSONArray(summonerLeagueBySummonerIdRequest.body());

        String summonerRank = "Unranked";
        int summonerRankedWins = 0, summonerRankedLosses = 0;

        if (!summonerLeagueBySummonerIdJSON.isEmpty()) {
            for (int i = 0; i < summonerLeagueBySummonerIdJSON.length(); i++) {
                JSONObject summonerLeague = summonerLeagueBySummonerIdJSON.getJSONObject(i);
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
        JSONObject summonerByNameJSON = new JSONObject(summonerByNameRequest.body());

        HttpResponse<String> gameByIdRequest = makeLeagueReguest("https://" + server + ".api.riotgames.com/lol/spectator/v4/active-games/by-summoner/" + summonerByNameJSON.getString("id"));
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
