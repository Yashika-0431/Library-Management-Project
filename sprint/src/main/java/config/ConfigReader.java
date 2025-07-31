package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;

    public static Properties getProperties() {
        if (prop == null) {
            prop = new Properties();
            try {
                FileInputStream fis = new FileInputStream("src/main/resources/properties/Setup.properties");
                prop.load(fis);
            } catch (IOException e) {
                System.out.println("Error loading configuration: " + e.getMessage());
            }
        }
        return prop;
    }

}
