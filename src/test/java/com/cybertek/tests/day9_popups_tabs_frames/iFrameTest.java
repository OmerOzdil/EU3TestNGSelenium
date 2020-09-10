package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iFrameTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/iframe");

        //How to switch frames
        //1. Switch using by name or ID attribute of iframe
        driver.switchTo().frame("mce_0_ifr");

        WebElement box = driver.findElement(By.id("tinymce"));

        // Clear the box before sending a text
        box.clear();

        //send text
        box.sendKeys("Mike Smith");
    }
}
