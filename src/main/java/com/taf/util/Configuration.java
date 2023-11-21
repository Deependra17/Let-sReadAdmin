package com.taf.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    public String getUrl() {
        return url;
    }

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    private String url;
    private String email;
    private String password;

    Configuration() {

        try (
                InputStream input = new FileInputStream("/home/deependra17/LetsRead/src/main/resources/config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);
            this.url = prop.getProperty("url");
            this.email = prop.getProperty("email");
            this.password = prop.getProperty("password");

        } catch (
                IOException ex) {
            ex.printStackTrace();
        }

    }
}
