package fi.kooditiimi.league;

import fi.kooditiimi.App;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class HandleLeagueReguest {

    public HandleLeagueReguest() {}

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
        LeagueProfile profile = api.getProfile(name, server);
        System.out.println("Summoner: " + profile.getSummonerName() + " " + profile.getSummonerRank());
    }

}
