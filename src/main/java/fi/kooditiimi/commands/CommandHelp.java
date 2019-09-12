package fi.kooditiimi.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;


public class CommandHelp {

    public static void commandHelp(GuildMessageReceivedEvent event) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("Statsbot - Help");
        embed.setDescription("List of statbots commands:");
        embed.addField("Help", "Brings up this menu", true);
        embed.addField("Info", "Shows some useless information", true);
        embed.setColor(Color.RED);
        event.getChannel().sendMessage(embed.build()).queue();
        embed.clear();
    }
}
