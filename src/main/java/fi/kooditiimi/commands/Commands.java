package fi.kooditiimi.commands;

import fi.kooditiimi.App;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split("\\s+");



        if (args[0].equalsIgnoreCase(App.prefix + "help")) {
            CommandHelp.commandHelp(event);
        }
        if (args[0].equalsIgnoreCase(App.prefix + "info")) {
            CommandInfo.commandInfo(event);
        }



        if(args[0].equalsIgnoreCase(App.prefix + "lol")) {

            if (args[1].equalsIgnoreCase("profile")) {
                CommandLolProfile.commandStats(event, args[2].toLowerCase());
            }
            if (args[1].equalsIgnoreCase("region")) {
                if (args[2] != null) {
                    System.out.println("DDASDADA");
                    CommandLolRegion.commandLolRegion(event, args[1].toLowerCase());  //TODO vähän heikko suoritus
                }
                CommandLolRegion.commandLolRegion(event, args[2].toLowerCase());
            }
        }
    }

}
