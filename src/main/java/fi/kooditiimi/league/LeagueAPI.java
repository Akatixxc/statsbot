package fi.kooditiimi.league;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LeagueAPI {

    public LeagueAPI() {}

    public LeagueProfile getProfile(String name, String server) {

        HttpResponse<String> summonerByNameRequest = makeLeagueReguest("https://"+ server +".api.riotgames.com/lol/summoner/v4/summoners/by-name/"+ name);

        JSONObject summonerIdJson = new JSONObject(summonerByNameRequest);
        String summonerId = summonerIdJson.getJSONObject("").getString("id");
        String accountID = summonerIdJson.getJSONObject("").getString("accountId");
        String summonerName = summonerIdJson.getJSONObject("").getString("name");
        //server tässä välissä, mutta käytetään tota jo annettua
        int summonerLevel = summonerIdJson.getJSONObject("").getInt("summonerLevel");
        int profileIconId = summonerIdJson.getJSONObject("").getInt("profileIconId");

        HttpResponse<String> summonerLeagueBySummonerIdRequest = makeLeagueReguest("https://"+ server +".api.riotgames.com/lol/league/v4/entries/by-summoner/"+ summonerId);
        JSONArray summonerLeagueJsonA = new JSONArray(summonerLeagueBySummonerIdRequest).getJSONArray(1);
        JSONObject summonerLeagueJsonO = new JSONObject(summonerLeagueJsonA);
        String summonerRank = summonerLeagueJsonO.getJSONObject("").getString("tier") +
                summonerLeagueJsonO.getJSONObject("").getString("rank") +
                summonerLeagueJsonO.getJSONObject("").getInt("leaguePoints");
        int summonerRankedWins = summonerLeagueJsonO.getJSONObject("").getInt("wins");
        int summonerRankedLosses = summonerLeagueJsonO.getJSONObject("").getInt("losses");

        return new LeagueProfile(summonerId, accountID, summonerName, server, summonerLevel, summonerRank, summonerRankedWins, summonerRankedLosses, profileIconId);
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
