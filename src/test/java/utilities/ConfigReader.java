package utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        String path = "configuration.properties";
        try (FileInputStream input = new FileInputStream(path)) {
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            System.err.println("Failed to load configuration file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {

        return System.getProperty(key, properties.getProperty(key));
    }
}

