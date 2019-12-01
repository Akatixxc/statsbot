package fi.kooditiimi;

import fi.kooditiimi.commandsvanha.Commands;
import fi.kooditiimi.KeyReader;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;
import java.io.IOException;

public class App {

    public static String PREFIX = ">";

    public static void main(String[] args) {
        startApplication();
    }

    private static void startApplication() {
        JDA jda;

        try {

            jda = new JDABuilder(KeyReader.get_key("discord")).build();
            jda.getPresence().setStatus(OnlineStatus.ONLINE);
            jda.getPresence().setActivity(Activity.watching("your stats"));

            jda.addEventListener(new Commands());

        } catch(LoginException | IOException e) {
            System.err.println("Login exception, API key is wrong: " + e);
        }


    }
}
