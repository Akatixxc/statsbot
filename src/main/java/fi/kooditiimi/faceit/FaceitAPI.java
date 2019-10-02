package fi.kooditiimi.faceit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FaceitAPI {

    public FaceitAPI() {
    }

    public FaceitProfile getProfileByName(String name){
        try{
            HttpResponse<String> profileByNameRequest = makeFaceitReguest("https://open.faceit.com/data/v4/players?nickname=" + name);
            JSONObject profileByNameJSON = new JSONObject(profileByNameRequest.body());

            String playerId = profileByNameJSON.getString("player_id");
            String nickname = profileByNameJSON.getString("nickname");
            String avatar = profileByNameJSON.getString("avatar");
            String country = profileByNameJSON.getString("country");

            JSONObject profileGamesJSON = new JSONObject(profileByNameJSON.get("games").toString()); //TODO nää samaan
            JSONObject profileGamesCsgoJSON = new JSONObject(profileGamesJSON.get("csgo").toString());

            int skillLevel = profileGamesCsgoJSON.getInt("skill_level");
            int faceitElo = profileGamesCsgoJSON.getInt("faceit_elo");

            HttpResponse<String> gameByPlayerIdRequest = makeFaceitReguest("https://open.faceit.com/data/v4/players/" + playerId + "/stats/csgo");
            JSONObject gameByPlayerIdJSON = new JSONObject(gameByPlayerIdRequest.body());
            JSONObject lifetimeJSON = new JSONObject(gameByPlayerIdJSON.get("lifetime").toString());

            String averageHS = lifetimeJSON.getString("Average Headshots %");
            String averageKD = lifetimeJSON.getString("Average K/D Ratio");
            String currentWS = lifetimeJSON.getString("Current Win Streak");
            String longestWS = lifetimeJSON.getString("Longest Win Streak");

            JSONArray recentMatchesJSON = new JSONArray(lifetimeJSON.get("Recent Results").toString());
            String[] recentMatches = new String[recentMatchesJSON.length()];
            for (int i = 0; i < recentMatchesJSON.length(); i++ ){
                recentMatches[i] = recentMatchesJSON.get(i).toString();
            }

            String matches = lifetimeJSON.getString("Matches");
            String wins = lifetimeJSON.getString("Wins");
            String winRate = lifetimeJSON.getString("Win Rate %");

            return new FaceitProfile(playerId, nickname, avatar, country, skillLevel, faceitElo, averageHS, averageKD, currentWS, longestWS, recentMatches, matches, wins, winRate);
        } catch (JSONException e) {
            return null;
        }
    }

    private HttpResponse<String> makeFaceitReguest(String url) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .headers("Authorization", "Bearer 5366277a-05ba-466e-9cb5-25565398feaf")
                    .build();

            return client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (Exception e) {
            System.err.println("Something is wrong with the api request: " + e);
            return null;
        }
    }
}
