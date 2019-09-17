package fi.kooditiimi;

import fi.kooditiimi.commandsvanha.Commands;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class App {

    public static String PREFIX = ">";

    public static void main(String[] args) throws LoginException {
        startApplication();
    }

    private static void startApplication() {
        JDA jda;

        try {

            jda = new JDABuilder("NjE4MTIyODA5ODI2MjE0MDIx.XW1nDw.U-GtQFn5Jp6lfkm204fKQkX1p3g").build();
            jda.getPresence().setStatus(OnlineStatus.ONLINE);
            jda.getPresence().setActivity(Activity.watching("Brooklyn99"));

            jda.addEventListener(new Commands());

        } catch(LoginException e) {
            System.err.println("Login exception, API key is wrong: " + e);
        }


    }
}
