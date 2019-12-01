package fi.kooditiimi.pubg;

import fi.kooditiimi.KeyReader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PubgAPI {

    public PubgAPI() {
    }

    public PubgProfile getStatsByName(String gamemode, String name) {
        try {
            HttpResponse<String> idByNameRequest = makePubgRequest("https://api.pubg.com/shards/steam/players?filter[playerNames]=" + name);
            JSONObject idByNameJSON = new JSONObject(idByNameRequest.body());

            //pelaajan nimenä voi käyttää String name
            String accountId = idByNameJSON.getJSONArray("data").getJSONObject(0).getString("id");

            // URL:ssa lifetimen tilalle voi laittaa sesason ID:n jos haluaa joskus tarkan seasonin arvot
            //Season id: division.bro.official.pc-2018-05 (17.11.2019)
            //Season id pitää vaihtaa manuaalisesti ellei halua hukata ythä requestiä siihen (maksimi on 10/min)
            HttpResponse<String> seasonStatsRequest = makePubgRequest("https://api.pubg.com/shards/steam/players/" + accountId + "/seasons/lifetime");
            JSONObject seasonStatsJSON = new JSONObject(seasonStatsRequest.body());
            JSONObject gameModeStats = seasonStatsJSON.getJSONObject("data").getJSONObject("attributes").getJSONObject("gameModeStats").getJSONObject(gamemode);

            int assists = gameModeStats.getInt("assists");
            int dBNOs = gameModeStats.getInt("dBNOs");
            int dailyKills = gameModeStats.getInt("dailyKills");
            int dailyWins = gameModeStats.getInt("dailyWins");
            double damageDealt = gameModeStats.getNumber("damageDealt").doubleValue();
            int headshotKills = gameModeStats.getInt("headshotKills");
            int kills = gameModeStats.getInt("kills");
            double longestKill = gameModeStats.getNumber("longestKill").doubleValue();
            double longestTimeSurvived = gameModeStats.getNumber("longestTimeSurvived").doubleValue();
            int losses = gameModeStats.getInt("losses");
            int maxKillStreaks = gameModeStats.getInt("maxKillStreaks");
            int mostSurvivalTime = gameModeStats.getInt("mostSurvivalTime");
            double rankPoints = gameModeStats.getNumber("rankPoints").doubleValue();
            String rankPointsTitle = gameModeStats.getString("rankPointsTitle");
            int revives = gameModeStats.getInt("revives");
            int roadKills = gameModeStats.getInt("roadKills");
            int roundMostKills = gameModeStats.getInt("roundMostKills");
            int roundsPlayed = gameModeStats.getInt("roundsPlayed");
            int suicides = gameModeStats.getInt("suicides");
            int teamKills = gameModeStats.getInt("teamKills");
            double timeSurvived = gameModeStats.getNumber("timeSurvived").doubleValue();
            int top10s = gameModeStats.getInt("top10s");
            int vehicleDestroys = gameModeStats.getInt("vehicleDestroys");
            int weeklyKills = gameModeStats.getInt("weeklyKills");
            int weeklyWins = gameModeStats.getInt("weeklyWins");
            int wins = gameModeStats.getInt("wins");

            return new PubgProfile(name, accountId, assists, dBNOs, dailyKills, dailyWins, damageDealt, headshotKills, kills, longestKill, longestTimeSurvived, losses, maxKillStreaks, mostSurvivalTime, rankPoints, rankPointsTitle, revives, roadKills, roundMostKills, roundsPlayed, suicides, teamKills, timeSurvived, top10s, vehicleDestroys, weeklyKills, weeklyWins, wins);

        } catch (JSONException e) {
            //System.err.println(e);
            return null;
        }
    }
    // Match id: 750fe37a-1f8f-4bda-8001-13f0795ce4ad
    private HttpResponse<String> makePubgRequest(String url) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .header("Authorization", KeyReader.get_key("pubg"))
                    .header("Accept", "application/vnd.api+json")
                    .build();

            return client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (Exception e) {
            System.err.println("Something is wrong with the api request: " + e);
            return null;
        }
    }
}
