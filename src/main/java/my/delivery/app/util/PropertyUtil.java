package my.delivery.app.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

    public static String getDbProperty(String key) {
        Properties prop = new Properties();
        try {
            ClassLoader classLoader = PropertyUtil.class.getClassLoader();
            File file = new File(classLoader.getResource("db.properties").getFile());
            InputStream inputStream = new FileInputStream(file);
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }
}
