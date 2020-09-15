package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HoverTest {
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
        /**
         * hover over each image in the website
         * verify each name:user text is displayed
         */

        driver.get("http://practice.cybertekschool.com/hovers");

        Actions action = new Actions(driver);

        List<WebElement> imgLocations = driver.findElements(By.xpath("//img"));
        System.out.println(imgLocations.size());

        List<WebElement> texts = driver.findElements(By.xpath("(//h5)"));
        System.out.println(texts.size());
        int index=0;
        for (WebElement img: imgLocations) {

            action.moveToElement(img).perform();
            Thread.sleep(1000);
            System.out.println(texts.get(index).getText());
            Assert.assertTrue(texts.get(index).isDisplayed());
            index++;
        }

    }
}
