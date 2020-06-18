package android.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertiesReader {
    private static final String configFilePath = "src/main/resources/application.properties";

    public static Properties config() {
        Properties properties = null;
        try {
            properties = new Properties();
            properties.load(new InputStreamReader(new FileInputStream(new File(configFilePath)), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}
