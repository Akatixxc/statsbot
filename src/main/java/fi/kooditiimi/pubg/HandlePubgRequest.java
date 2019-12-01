package fi.kooditiimi.pubg;

import fi.kooditiimi.App;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

public class HandlePubgRequest {

    public HandlePubgRequest() {
    }

    public void handleRequest(String[] args, GuildMessageReceivedEvent event) {

        String command;
        String gamemode;
        String name;

        try {
            command = args[1].toLowerCase();
            gamemode = args[2].toLowerCase();
            name = args[3];

        } catch (IndexOutOfBoundsException e) {
            printCommandNotFoundMessage(event, "");
            return;
        }

        switch (command) {
            case "stats":
                printStats(event, gamemode, name);
                break;
            /*case "game":            //Joskus voisi tehdä esim 5 viimeistä peliä
                printProfile(event, name);
                break;*/
            default:
                printCommandNotFoundMessage(event, command);

        }
    }

    private void printCommandNotFoundMessage(GuildMessageReceivedEvent event, String command) {
        event.getChannel().sendMessage(new EmbedBuilder().setColor(Color.RED).setTitle("Command " + command + " not found, you can get help by typing: " + App.PREFIX + "help").build()).queue();
    }

    private void printStats(GuildMessageReceivedEvent event, String gamemode, String name) {

        PubgAPI api = new PubgAPI();
        PubgProfile profile = api.getStatsByName(gamemode, name);
        EmbedBuilder embed = new EmbedBuilder();

        if (profile == null) {
            embed.setTitle("Player or gamemode not found!");
            embed.addField("Player not found", "Use upper and lower cased letters if needed", false);
            embed.addField("Gamemodes", "solo, solo-fpp, duo, duo-fpp, squad, squad-fpp", false);
            embed.setColor(Color.RED);
            event.getChannel().sendMessage(embed.build()).queue(message -> message.delete().queueAfter(20, TimeUnit.SECONDS));
        } else {

            embed.setTitle(profile.getNickname());
            embed.addField("Games played", profile.getRoundsPlayed() + "", true);
            embed.addField("Kills", profile.getKills() + "", true);
            embed.addField("K/D Ratio", new DecimalFormat("##.##").format(profile.getKdRatio()) + "", true);
            embed.addField("Wins", profile.getWins() + "", true);
            embed.addField("Losses", profile.getLosses() + "", true);
            embed.addField("Winrate", profile.getWinRate() / 100.0 + " %", true);
            embed.addField("Most kills in a game", profile.getRoundMostKills() + "", true);
            embed.addField("Headshot Kills", profile.getHeadshotKills() + "", true);
            embed.addField("HS Rate", profile.getHsRate() / 100.0 + " %", true);
            embed.addField("Best Killstreak", profile.getMaxKillStreaks() + "", true);
            embed.addField("Damage Dealt", Math.round(profile.getDamageDealt()) + "", true);
            embed.addField("Downed But Not Killed", profile.getdBNOs() + "", true);
            embed.addField("Longest Kill", new DecimalFormat("##.##").format(profile.getLongestKill()) + " m", true);
            embed.addField("Assists", profile.getAssists() + "", true);
            embed.addField("Road Kills", profile.getRoadKills() + "", true);
            embed.addField("Longest Time Survived", (int) profile.getLongestTimeSurvived() / 60 + " min", true);
            embed.addField("Most Survival Time?", profile.getMostSurvivalTime() + "", true);
            embed.addField("Time Survived", (int) profile.getTimeSurvived() / 3600 + " hours", true);
            embed.addField("Revives", profile.getRevives() + "", true);
            embed.addField("Suicides", profile.getSuicides() + "", true);
            embed.addField("Team Kills", profile.getTeamKills() + "", true);
            embed.addField("Vehicles Destroyed", profile.getVehicleDestroys() + "", true);
            embed.addField("Top 10s", profile.getTop10s() + "", true);

            embed.setColor(Color.RED);
            event.getChannel().sendMessage(embed.build()).queue();
            embed.clear();
        }
    }

}
