package com.taf;

import com.taf.util.DriverFactory;
import com.taf.util.LoginUtil;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.junit.jupiter.api.Test;

@MicronautTest
public class LoginTest {
    private WebDriver driver;

    LoginUtil loginUtil;

    public void parentHandle() {
        driver.switchTo().window(loginUtil.getParentHandle());
    }

//    @BeforeMethod
//    @Parameters({"browser"})
//    public void beforeMethod(String browser) {
////        driver = DriverFactory.build(browser);
//        driver = new DriverFactory().build("chrome");
//        loginUtil = new LoginUtil(driver);
//    }

    @Test()
    public void testLogin() throws InterruptedException {
        browser("chrome");
        browser("firefox");

        // driver.quit();
    }

    public void browser(String brow) throws InterruptedException {
        driver = new DriverFactory().build(brow);
        loginUtil = new LoginUtil(driver);
        loginUtil.Login();
        parentHandle();
        String expectedTitle = "Let's Read";
        String actualTitle = driver.getTitle();
        System.out.println("Actual result: " + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "LetsRead Failed!");

        // driver.quit();
    }

//    @AfterMethod
//    public void tearDown(ITestResult result) {
//        // src.takeScreenshotOnFailure(driver, result);
//        driver.quit();
//    }
}
