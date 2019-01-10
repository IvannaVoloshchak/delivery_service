package my.delivery.app.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

    public static String getDbProperty(String key) {
        Properties prop = new Properties();
        try {
            InputStream inputStream = new FileInputStream("C:/Projects/DeliveryService/src/main/resources/db.properties");
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }
}
