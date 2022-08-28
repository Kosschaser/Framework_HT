package services;

import java.util.ResourceBundle;

public class TestDataReader {

    private static ResourceBundle bundle = ResourceBundle.getBundle(System.getProperty("environment"));

    public static String getTestData(String key) {
        return  bundle.getString(key);
    }

}
