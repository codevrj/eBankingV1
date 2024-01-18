package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties properties;

    public ReadConfig() {
        File src = new File("./Configuration/config.properties");

        try {
            FileInputStream fis = new FileInputStream(src);
            properties = new Properties();
            properties.load(fis);
        } catch (Exception e) {
            System.out.println("Error " + e + "occurred.");
        }
    }
    public String getUrl(){
        String url = properties.getProperty("baseUrl");
        return url;
    }
    public String getUserName(){
        String us = properties.getProperty("userName");
        return us;
    }
    public String getPassword(){
        String pw = properties.getProperty("password");
        return pw;
    }
}
