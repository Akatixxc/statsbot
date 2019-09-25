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
            /*case "game":            Joskus voisi tehdä esim 5 viimeistä peliä
                printGame(event, name);
                break;*/
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

        embed.setThumbnail(profile.getAvatar());
        embed.setTitle(String.valueOf(profile.getFaceitElo()));
        embed.setColor(Color.RED);
        event.getChannel().sendMessage(embed.build()).queue();
        embed.clear();
    }

}
