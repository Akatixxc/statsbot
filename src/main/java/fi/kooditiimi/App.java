package fi.kooditiimi;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.datapipeline.common.expiration.ExpirationPeriod;
import com.merakianalytics.orianna.types.common.Region;
import fi.kooditiimi.commands.Commands;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 */
public class App {

    public static JDA jda;
    public static String prefix = ">";
    public static Region region = Region.EUROPE_NORTH_EAST;

    public static void main(String[] args) throws LoginException {

        jda = new JDABuilder("NjE4MTIyODA5ODI2MjE0MDIx.XW1nDw.U-GtQFn5Jp6lfkm204fKQkX1p3g").build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.watching("Chat"));

        jda.addEventListener(new Commands());

        Orianna.Configuration config = new Orianna.Configuration();
        config.setCurrentVersionExpiration(ExpirationPeriod.create(6, TimeUnit.HOURS));
        Orianna.setRiotAPIKey("RGAPI-b9e8bbc6-45ec-4ccb-ba63-b17368c21b3b");

    }

    public static void setRegion(Region newRegion){
        region = newRegion;
    }
    public static String getRegion() {
        return region.toString();
    }

}
