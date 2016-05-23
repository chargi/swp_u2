package classes.helper;

/**
 * Created by Chargi on 23.5.2016.
 */
public class HomeDirTranslator {
    public static String replaceTilde(String path) {
        return path.replace("~", System.getProperty("user.home"));
    }
}
