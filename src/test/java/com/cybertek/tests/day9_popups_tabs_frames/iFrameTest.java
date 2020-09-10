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

        Thread.sleep(1000);

        // goes back to first frame(main Html)
        // goes back to first frame, useful when we have switched multiple frames.
        driver.switchTo().defaultContent();

        //2.Switching before sendKeys
        driver.switchTo().frame(0);

        //clear before sending text
        box.clear();
        box.sendKeys("Mike Smith with index");
        Thread.sleep(1000);

        // second way to switch parent(only one way goes back)
        driver.switchTo().parentFrame();

        //3.Using WebElement
        WebElement iframeElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframeElement);

        box.sendKeys("Mike Smith with WebElement");
        Thread.sleep(1000);

    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");

        // switching to frame top
        driver.switchTo().frame("frame-top");
        //top has 3 frame under left middle and right
        // switch to frame middle
        driver.switchTo().frame("frame-middle");

        System.out.println(driver.findElement(By.tagName("body")).getText());

        //switch to the top frame
        driver.switchTo().parentFrame();
        // switch to the right frame
        driver.switchTo().frame(2);
        System.out.println(driver.findElement(By.tagName("body")).getText());

        //
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();

        driver.switchTo().frame(1);

        System.out.println(driver.findElement(By.tagName("body")).getText());
    }
}
