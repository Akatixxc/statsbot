package fi.kooditiimi.commandsvanha;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;


public class CommandInfo {

    public static void commandInfo(GuildMessageReceivedEvent event) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("Statsbot - Info");
        embed.setDescription("LAMAO");
        embed.addField("Version number", "No", true);
        embed.addField("Info", "Literally useless", true);
        embed.setColor(Color.RED);
        event.getChannel().sendMessage(embed.build()).queue();
        embed.clear();
    }

}
