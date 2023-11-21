package com.taf.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
    private WebDriver driver;
    public DriverFactory(){
    }
    public WebDriver build(String browser) {

        if (driver != null) return driver;

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options= new FirefoxOptions();
            //options.setHeadless(true);

            driver = new FirefoxDriver(options);
        }
        return driver;
    }
}
