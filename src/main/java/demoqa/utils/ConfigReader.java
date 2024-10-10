package demoqa.utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    private ConfigReader(){
        //Singleton pattern
    }

    static {
        try {
            String path = "src/main/resources/app.properties";
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(path);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getValue(String key){
        return properties.getProperty(key).trim();
    }
}

