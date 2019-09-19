package fi.kooditiimi.commandsvanha;

import fi.kooditiimi.App;
import fi.kooditiimi.league.HandleLeagueReguest;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

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
                HandleLeagueReguest lolrequest = new HandleLeagueReguest();
                lolrequest.handleRequest(args, event);
                break;
            default:
                printCommandNotFoundMessage(event, firstArgument);
        }

/*
        if(prefixAndCommandOrGame.equals(App.PREFIX + "lol")) {

            if (region.equals("profile")) {
                CommandLolProfile.commandStats(event, player);
            }
            if (region.equals("region")) {
                if (player != null) {
                    System.out.println("DDASDADA");
                    CommandLolRegion.commandLolRegion(event, region.toLowerCase());  //TODO vähän heikko suoritus
                }
                CommandLolRegion.commandLolRegion(event, player.toLowerCase());
            }
        }
        */
    }

    private void printCommandNotFoundMessage(GuildMessageReceivedEvent event, String command) {
        event.getChannel().sendMessage("Command: " + command + " not found, you can get help by typing " + App.PREFIX + "help").queue();
    }



}