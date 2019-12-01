package fi.kooditiimi.commandsvanha;

import fi.kooditiimi.App;
import fi.kooditiimi.faceit.HandleFaceitRequest;
import fi.kooditiimi.pubg.HandlePubgRequest;
import fi.kooditiimi.league.HandleLeagueRequest;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class Commands extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){

        String[] args = event.getMessage().getContentRaw().split("\\s+");

        String prefixAndFirstArgument = args[0].toLowerCase();

        if(!prefixAndFirstArgument.startsWith(App.PREFIX)) {
            return;
        }

        String firstArgument = prefixAndFirstArgument.split(App.PREFIX)[1];

        switch (firstArgument) {
            case "help":
                HelperCommands help = new HelperCommands(CommandTypes.HELP, event);
                help.printHelperMessage();
                break;
            case "info":
                HelperCommands info = new HelperCommands(CommandTypes.INFO, event);
                info.printHelperMessage();
                break;
            case "lol":
                HandleLeagueRequest lolrequest = new HandleLeagueRequest();
                lolrequest.handleRequest(args, event);
                break;
            case "faceit":
                HandleFaceitRequest faceitrequest = new HandleFaceitRequest();
                faceitrequest.handleRequest(args, event);
                break;
            case "pubg":
                HandlePubgRequest pubgrequest = new HandlePubgRequest();
                pubgrequest.handleRequest(args, event);
                break;
            default:
                printCommandNotFoundMessage(event, firstArgument);
        }
    }

    private void printCommandNotFoundMessage(GuildMessageReceivedEvent event, String command) {
        event.getChannel().sendMessage(new EmbedBuilder().setColor(Color.RED).setTitle("Command " + command + " not found, you can get help by typing: " + App.PREFIX + "help").build()).queue();
    }



}