package fi.kooditiimi.commandsvanha;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;

//TODO: mieti parempi tapa suorittaa tämä toiminto.
public class HelperCommands {

    private CommandTypes commandType;
    private GuildMessageReceivedEvent event;

    public HelperCommands(CommandTypes commandType, GuildMessageReceivedEvent event) {
        this.commandType = commandType;
        this.event = event;
    }

    public void printHelperMessage() {
        if(this.commandType == CommandTypes.HELP) {
            printHelpMessage();
        } else if(this.commandType == CommandTypes.INFO) {
            printInfoMessage();
        }
    }

    private void printInfoMessage() {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("Statsbot - Info");
        embed.setDescription("LAMAO");
        embed.addField("Version number", "No", true);
        embed.addField("Info", "Literally useless", true);
        embed.setColor(Color.RED);
        this.event.getChannel().sendMessage(embed.build()).queue();
        embed.clear();
    }

    private void printHelpMessage() {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("Statsbot - Help");
        embed.setDescription("List of statbots commands:");
        embed.addField("Help", "Brings up this menu", true);
        embed.addField("Info", "Shows some useless information", true);
        embed.setColor(Color.RED);
        this.event.getChannel().sendMessage(embed.build()).queue();
        embed.clear();
    }
}
