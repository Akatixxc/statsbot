package fi.kooditiimi.faceit;

import fi.kooditiimi.App;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;

public class HandleFaceitRequest {

    public HandleFaceitRequest() {
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
                printProfile(event, name);
                break;
            case "game":            //Joskus voisi tehdä esim 5 viimeistä peliä
                printProfile(event, name);
                break;
            default:
                printCommandNotFoundMessage(event, command);

        }
    }

    private void printCommandNotFoundMessage(GuildMessageReceivedEvent event, String command) {
        event.getChannel().sendMessage("Command: " + command + " not found, you can get help by typing " + App.PREFIX + "help").queue();
    }

    private void printProfile(GuildMessageReceivedEvent event, String name) {
        
        FaceitAPI api = new FaceitAPI();
        FaceitProfile profile = api.getProfileByName(name);
        EmbedBuilder embed = new EmbedBuilder();

        //embed.setThumbnail(profile.getAvatar());
        embed.setTitle(profile.getNickname());
        embed.setDescription(" *from " + profile.getCountry() + "*");
        embed.addField("Skill level:", String.valueOf(profile.getSkillLevel()), true);
        embed.addField("ELO:", String.valueOf(profile.getFaceitElo()), true);
        embed.addField("Average K/D:", profile.getAverageKD(), true);
        embed.addField("Average Headshot %:", profile.getAverageHS() + " %", true);
        embed.addField("Win Rate:", profile.getWinRate() + " %", true);
        embed.addField("Recent matches:", profile.recentMatchesToString(), true);
        embed.addField("Won Matches:", profile.getWins(), true);
        embed.addField("Total Matches:", profile.getMatches(), true);
        embed.addField("Current Win Streak", profile.getCurrentWS(), true);
        embed.addField("Longest Win Streak:", profile.getLongestWS(), true);
        embed.setColor(Color.RED);
        event.getChannel().sendMessage(embed.build()).queue();
        embed.clear();
    }

}
