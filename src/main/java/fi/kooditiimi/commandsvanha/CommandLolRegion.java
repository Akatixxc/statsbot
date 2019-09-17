package fi.kooditiimi.commandsvanha;

import com.merakianalytics.orianna.types.common.Region;
import fi.kooditiimi.App;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;

public class CommandLolRegion {

    public static void commandLolRegion(GuildMessageReceivedEvent event, String arg2) {
/*        switch (arg2) {
            case "br":
                App.setRegion(Region.BRAZIL);
                regionSetTo(event);
                break;
            case "eune":
                App.setRegion(Region.EUROPE_NORTH_EAST);
                regionSetTo(event);
                break;
            case "euw":
                App.setRegion(Region.EUROPE_WEST);
                regionSetTo(event);
                break;
            case "jp":
                App.setRegion(Region.JAPAN);
                regionSetTo(event);
                break;
            case "kr":
                App.setRegion(Region.KOREA);
                regionSetTo(event);
                break;
            case "lan":
                App.setRegion(Region.LATIN_AMERICA_NORTH);
                regionSetTo(event);
                break;
            case "las":
                App.setRegion(Region.LATIN_AMERICA_SOUTH);
                regionSetTo(event);
                break;
            case "na":
                App.setRegion(Region.NORTH_AMERICA);
                regionSetTo(event);
                break;
            case "oce":
                App.setRegion(Region.OCEANIA);
                regionSetTo(event);
                break;
            case "ru":
                App.setRegion(Region.RUSSIA);
                regionSetTo(event);
                break;
            case "tr":
                App.setRegion(Region.TURKEY);
                regionSetTo(event);
                break;
            default:
                EmbedBuilder embed = new EmbedBuilder();
                embed.setTitle("Current region: " + App.getRegion());
                embed.addField("Valid servers:", "EUNE, EUW, NA, Ru, Kr, Jp, Br, Tr, LAN, LAS, OCE", true);
                embed.setColor(Color.RED);
                event.getChannel().sendMessage(embed.build()).queue();
                embed.clear();
        }*/
    }

/*    public static void regionSetTo(GuildMessageReceivedEvent event) {
        event.getChannel().sendMessage("Region set to: " + App.getRegion()).queue();
    }*/

}
