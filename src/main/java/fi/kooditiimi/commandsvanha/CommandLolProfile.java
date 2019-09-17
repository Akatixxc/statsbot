package fi.kooditiimi.commandsvanha;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Queue;
import com.merakianalytics.orianna.types.common.Region;
import fi.kooditiimi.App;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;


public class CommandLolProfile {
    public static void commandStats(GuildMessageReceivedEvent event, String name) {
/*        EmbedBuilder embed = new EmbedBuilder();

        System.out.println(Orianna.summonerNamed(name).withRegion(App.region).get().getLeaguePosition(Queue.RANKED_SOLO_5x5).getTier());

        embed.setThumbnail(Orianna.summonerNamed(name).withRegion(Region.EUROPE_NORTH_EAST).get().getProfileIcon().getImage().getURL());
        embed.setTitle(name);
        embed.addField("Level:",
                String.valueOf(Orianna.summonerNamed(name).withRegion(App.region).get().getLevel()), true);
        embed.addField("Mastery score:",
                String.valueOf(Orianna.summonerNamed(name).withRegion(App.region).get().getChampionMasteryScore().getScore()), true);
        //try {
            embed.addField("Rank:",
                    Orianna.summonerNamed(name).withRegion(App.region).get()
                            + " " + Orianna.summonerNamed(name).withRegion(App.region).get().getLeaguePosition(Queue.RANKED_SOLO_5x5).getDivision()
                            + " " + Orianna.summonerNamed(name).withRegion(App.region).get().getLeaguePosition(Queue.RANKED_SOLO_5x5).getLeaguePoints()
                            + "LP", true);

            int wins = Orianna.summonerNamed(name).withRegion(App.region).get().getLeaguePosition(Queue.RANKED_SOLO_5x5).getWins();
            int losses = Orianna.summonerNamed(name).withRegion(App.region).get().getLeaguePosition(Queue.RANKED_SOLO_5x5).getLosses();
            int winRatio = wins*100/(wins+losses);

            embed.addField("Ranked W/L/%", wins + " / " + losses + " / " + winRatio + "%", true);
        //} catch (Exception e) {
            embed.addField("Rank:", "Unranked", true);
        //}
        //System.out.println(Orianna.summonerNamed(name).withRegion(Region.EUROPE_NORTH_EAST).get().getChampionMasteries().get(0).getChampion().getName());
        embed.setColor(Color.RED);
        event.getChannel().sendMessage(embed.build()).queue();
        embed.clear();*/
    }
}
