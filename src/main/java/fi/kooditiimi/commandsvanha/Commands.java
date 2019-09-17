package fi.kooditiimi.commandsvanha;

import fi.kooditiimi.App;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){

        String[] args = event.getMessage().getContentRaw().split("\\s+");

        String prefixAndFirstArgument = args[0].toLowerCase();
        String firstArgument = prefixAndFirstArgument.split(App.PREFIX)[1];

        if(prefixAndFirstArgument.substring(0,App.PREFIX.length()).equals(App.PREFIX)) {
            return;
        }

        switch (firstArgument) {
            case "help":
                CommandHelp.commandHelp(event);
            case "info":
                CommandInfo.commandInfo(event);
            case "lol":
                //TODO: lol luokka
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
        event.getChannel().sendMessage("Command: " + command + "not found, you can get help by typing " + App.PREFIX + "help").queue();
    }



}