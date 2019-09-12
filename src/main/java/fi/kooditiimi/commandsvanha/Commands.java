package fi.kooditiimi.commandsvanha;

import fi.kooditiimi.App;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        for(String s : args) {

        }

        String prefixAndCommandOrGame = args[0].toLowerCase();
        String region = args[1].toLowerCase();
        String player = args[2].toLowerCase();




        if (prefixAndCommandOrGame.equals(App.PREFIX + "help")) {
            CommandHelp.commandHelp(event);
        }
        if (prefixAndCommandOrGame.equals(App.PREFIX + "info")) {
            CommandInfo.commandInfo(event);
        }



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
    }



}