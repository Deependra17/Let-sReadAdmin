package com.taf.pathway;

import com.taf.util.LoginUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class CreatePathway {
    private WebDriver driver;
    LoginUtil loginUtil;
    public void parentHandle() {
        driver.switchTo().window(loginUtil.getParentHandle());
    }
    public void ToCreatePathWay() throws InterruptedException {
        PathwaysLocators locate=new PathwaysLocators();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        loginUtil.Login();
        parentHandle();

        WebElement myElement=driver.findElement(By.xpath(locate.getClickOnPathway()));
        myElement.click();
        System.out.println("CLicked on pathway");

        WebElement pathway=driver.findElement(By.xpath(locate.getCreatePathway()));
        pathway.click();
        System.out.println("Clicked on Create pathway to create a new pathway");

        WebElement pathwayName=driver.findElement(By.xpath(locate.getEnterPathwaysName()));
        pathwayName.sendKeys("Stories");
        System.out.println("Pathway name is entered");

        WebElement intro=driver.findElement(By.xpath(locate.getEnterPathwayIntro()));
        intro.sendKeys("Enjoy reading these amazing stories");
        System.out.println("pathway is introduction is entered");

        WebElement UploadImage=driver.findElement(By.xpath(locate.getUploadImage()));
        UploadImage.click();
        System.out.println("image is uploaded successfully");
    }
}
