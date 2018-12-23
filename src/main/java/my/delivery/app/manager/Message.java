package my.delivery.app.manager;

import java.util.ResourceBundle;

public class Message {

    private static Message instance;
    private static  ResourceBundle resource;
    private static final String BUNDLE_NAME = "my.delivery.app.manager.messages";
    public static final String SERVLET_EXECPTION = "SERVLET_EXCEPTION";
    public static final String IO_EXCEPTION = "IO_EXCEPTION";
    public static final String LOGIN_ERROR = "LOGIN_ERROR";

    public static Message getInstance() {
        if (instance == null) {
            instance = new Message();
            instance.resource = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public static String getProperty(String key) {
        return (String) resource.getObject(key);
    }
}
