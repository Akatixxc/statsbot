package fi.kooditiimi.league;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class LeagueAPI {

    public LeagueAPI() {}

    public LeagueProfile getProfile(String name, String server) {

        HttpResponse<String> summonerIdRequest = makeLeagueReguest("https://"+ server +".api.riotgames.com/lol/summoner/v4/summoners/by-name/"+ name);
        JSONObject summonerIdJson = new JSONObject(summonerIdRequest);
        String summonerId = summonerIdJson.getJSONObject("").getString("accountId");


        return new LeagueProfile();
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
