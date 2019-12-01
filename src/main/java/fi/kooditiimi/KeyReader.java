package fi.kooditiimi;

import java.io.IOException;
import java.io.File;
import java.util.Scanner;


public class KeyReader {

    public KeyReader() {
    }

    public static String get_key(String tag) throws IOException {
        File file = new File(new File("keys.txt").getAbsolutePath());
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if (tag.equals(line.split(":")[0])){
                return line.split(":")[1];
            }
        }
        return tag;
    }

}
