package fi.kooditiimi.league;

import fi.kooditiimi.App;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.*;

public class HandleLeagueReguest {

    public HandleLeagueReguest() {
    }

    public void handleRequest(String[] args, GuildMessageReceivedEvent event) {

        LeagueAPI api = new LeagueAPI();

        String command;
        String name;
        String server;

        try {
            command = args[1];
            name = args[2];
            server = args[3];
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Command not formed well: " + e);
            event.getChannel().sendMessage("Command not formed well").queue();
            return;
        }

        switch (command) {
            case "profile":
                printProfile(event, name, server);
                break;
            case "game":
                printGame(event, name, server);
                break;
            default:
                printCommandNotFoundMessage(event, command);

        }

    }

    private void printCommandNotFoundMessage(GuildMessageReceivedEvent event, String command) {
        event.getChannel().sendMessage("Command: " + command + " not found, you can get help by typing " + App.PREFIX + "help").queue();
    }

    private void printProfile(GuildMessageReceivedEvent event, String name, String server) {
        LeagueAPI api = new LeagueAPI();
        LeagueProfile profile = api.getProfileByName(name, server);

        EmbedBuilder embed = new EmbedBuilder();

        embed.setThumbnail("http://stelar7.no/cdragon/latest/profile-icons/" + profile.getProfileIconId() + ".jpg");
        embed.setTitle(profile.getSummonerName());
        embed.addField("Level:", String.valueOf(profile.getSummonerLevel()), false);

        embed.addField("Rank:", profile.getSummonerRank(), false);

        if(!profile.getSummonerRank().equals("Unranked")) {
            int wins = profile.getSummonerRankedWins();
            int losses = profile.getSummonerRankedLosses();
            int winRatio = wins * 100 / (wins + losses);

            embed.addField("Ranked W/L/%", wins + " / " + losses + " / " + winRatio + "%", false);
        }

        embed.setColor(Color.RED);
        event.getChannel().sendMessage(embed.build()).queue();
        embed.clear();
    }

    private void printGame(GuildMessageReceivedEvent event, String name, String server) {
        try {
            LeagueAPI api = new LeagueAPI();
            JSONObject gameJSON = api.getGame(name, server);

            EmbedBuilder embed = new EmbedBuilder();
            JSONArray gameArray = new JSONArray(gameJSON.getJSONArray("participants").toString());

            for(int i = 0; i < gameArray.length(); i++) {
                try {
                    JSONObject summonerGame = gameArray.getJSONObject(i);
                    LeagueProfile profile = api.getInGameProfile(summonerGame.getString("summonerId"), server);

                    embed.setAuthor(summonerGame.getString("summonerName") + " | " + profile.getSummonerRank(),
                            "http://stelar7.no/cdragon/latest/champion-icons/" + summonerGame.getInt("championId") + ".png",
                            "http://stelar7.no/cdragon/latest/champion-icons/" + summonerGame.getInt("championId") + ".png");

                    if(!profile.getSummonerRank().equals("Unranked")) {
                        int wins = profile.getSummonerRankedWins();
                        int losses = profile.getSummonerRankedLosses();
                        int winRatio = wins * 100 / (wins + losses);

                        embed.setDescription("**" + winRatio + "**" + "% win rate in " + (wins + losses) + " games");
                    }

                    if (summonerGame.getLong("teamId") == 100) {
                        embed.setColor(42239);
                    } else {
                        embed.setColor(Color.RED);
                    }
                    event.getChannel().sendMessage(embed.build()).queue();
                    embed.clear();

                }catch(Exception e){ System.err.println(e); }
            }
        } catch (Exception e) { System.err.println(e); }
    }

}
