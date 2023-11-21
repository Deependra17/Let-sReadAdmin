package com.taf.util;

import com.taf.login.LoginLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.Set;

public class LoginUtil {
    private final WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public String getParentHandle() {
        return parentHandle;
    }

    private String parentHandle;

    public LoginUtil(WebDriver driver) {
        this.driver = driver;
    }
    public void Login() throws InterruptedException {
        Configuration config = new Configuration();
        LoginLocators locate= new LoginLocators();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(config.getUrl());
        System.out.println("URL is Entered");

        this.parentHandle = driver.getWindowHandle();
        System.out.println("Parent window - " + parentHandle);

        driver.findElement(By.xpath(locate.getContinueWithGoogle())).click();
        System.out.println("Continue with google is clicked");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Set<String> handles = driver.getWindowHandles();
        if (handles.size() <= 1) {
            System.out.println("No new windows found.");
            return;
        }
        for (String handle : handles) {
            if (!handle.equals(parentHandle)) {
                driver.switchTo().window(handle);
                System.out.println("Switched to new window with handle: " + handle);
                System.out.println("User is on the new window");
            }
        }

        WebElement email= driver.findElement(By.xpath(locate.getEnterEmail()));
        email.sendKeys(config.getEmail());
        driver.findElement(By.xpath(locate.getClickEmailButton())).click();
        Thread.sleep(3000);
        System.out.println("Email is Entered Successfully");

        WebElement password= driver.findElement(By.xpath(locate.getEnterPassword()));
        password.       sendKeys(config.getPassword());
        System.out.println("password is Entered successfully");

        driver.findElement(By.xpath(locate.getClickButton())).click();
        System.out.println("User logged in successfully");
    }
}
