package fi.kooditiimi.league;

import fi.kooditiimi.App;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.*;

public class HandleLeagueRequest {

    private static String SERVER = "eun1";

    public HandleLeagueRequest() {
    }

    public void handleRequest(String[] args, GuildMessageReceivedEvent event) {

        String command;
        String name;

        try {
            command = args[1];
            name = args[2];
        }
        catch (IndexOutOfBoundsException e) {
            System.err.println("Command not formed well: " + e);
            event.getChannel().sendMessage("Command not formed well").queue();
            return;
        }

        switch (command) {
            case "profile":
                printProfile(event, name, SERVER);
                break;
            case "game":
                printGame(event, name, SERVER);
                break;
            case "server":
                setServer(event, name); //name = kolmas arqumentti
                break;
            default:
                printCommandNotFoundMessage(event, command);

        }

    }

    private void printCommandNotFoundMessage(GuildMessageReceivedEvent event, String command) {
        event.getChannel().sendMessage("Command: " + command + " not found, you can get help by typing " + App.PREFIX + "help").queue();
    }

    private void printProfile(GuildMessageReceivedEvent event, String name, String server) {
        try {
            LeagueAPI api = new LeagueAPI();
            LeagueProfile profile = api.getProfileByName(name, server);

            EmbedBuilder embed = new EmbedBuilder();

            //ddragon url pitää päivittää uusimpaan versioon jos se ei löydä pikkukuvaa (9.18.1)
            embed.setThumbnail("http://ddragon.leagueoflegends.com/cdn/9.18.1/img/profileicon/" + profile.getProfileIconId() + ".png");
            embed.setTitle(profile.getSummonerName());
            embed.addField("Level:", String.valueOf(profile.getSummonerLevel()), false);

            embed.addField("Rank:", profile.getSummonerRank(), false);

            if (!profile.getSummonerRank().equals("Unranked")) {
                int wins = profile.getSummonerRankedWins();
                int losses = profile.getSummonerRankedLosses();
                int winRatio = wins * 100 / (wins + losses);

                embed.addField("Ranked W/L/%", wins + " / " + losses + " / " + winRatio + "%", false);
            }

            embed.setColor(Color.RED);
            event.getChannel().sendMessage(embed.build()).queue();
            embed.clear();
        }
        catch (NullPointerException e) {
            //System.err.println(e);
            EmbedBuilder embed = new EmbedBuilder();
            embed.addField("Summoner not found", "If name has spaces use _ (underscore). Also make sure you are on the right server.", true);
            embed.setColor(Color.RED);
            event.getChannel().sendMessage(embed.build()).queue();
            embed.clear();
        }
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
        } catch (Exception e) {
            //System.err.println(e);
            EmbedBuilder embed = new EmbedBuilder();
            embed.addField("Summoner not found or he isn't in game",
                    "If name has spaces use _ (underscore). Also make sure you are on the right server.", true);
            embed.setColor(Color.RED);
            event.getChannel().sendMessage(embed.build()).queue();
            embed.clear();
        }
    }

    private void setServer(GuildMessageReceivedEvent event, String server) {
        switch (server) {
            case "br":
                SERVER = "br1";
                event.getChannel().sendMessage("Server set to Brazil. (br1)").queue();
                break;
            case "eune":
                SERVER = "eun1";
                event.getChannel().sendMessage("Server set to EU Nordic and East. (eun1)").queue();
                break;
            case "euw":
                SERVER = "euw1";
                event.getChannel().sendMessage("Server set to EU West. (euw1)").queue();
                break;
            case "jp":
                SERVER = "jp1";
                event.getChannel().sendMessage("Server set to Japan. (jp1)").queue();
                break;
            case "kr":
                SERVER = "kr";
                event.getChannel().sendMessage("Server set to Korea. (kr)").queue();
                break;
            case "lan":
                SERVER = "la1";
                event.getChannel().sendMessage("Server set to Latin America North. (lan)").queue();
                break;
            case "las":
                SERVER = "la2";
                event.getChannel().sendMessage("Server set to Latin America South. (la2)").queue();
                break;
            case "na":
                SERVER = "na1";
                event.getChannel().sendMessage("Server set to North America. (na1)").queue();
                break;
            case "oce":
                SERVER = "oc1";
                event.getChannel().sendMessage("Server set to Oceania. (oc1)").queue();
                break;
            case "ru":
                SERVER = "ru";
                event.getChannel().sendMessage("Server set to Russia. (ru)").queue();
                break;
            case "tr":
                SERVER = "tr1";
                event.getChannel().sendMessage("Server set to Turkey. (tr1)").queue();
                break;
            default:
                EmbedBuilder embed = new EmbedBuilder();
                embed.setTitle("Current region: " + SERVER);
                embed.addField("Valid servers:", "EUNE, EUW, NA, Ru, Kr, Jp, Br, Tr, LAN, LAS, OCE", true);
                embed.setColor(Color.RED);
                event.getChannel().sendMessage(embed.build()).queue();
                embed.clear();
        }
    }
}