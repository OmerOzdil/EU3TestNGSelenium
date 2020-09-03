package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class displayedDemo {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement usernameInputBox = driver.findElement(By.id("username"));

        System.out.println(usernameInputBox.isDisplayed());

        // verify username inputbox is not displayed on the screen
        // click start button
        // veirfy username displayed on the screen.

        Assert.assertFalse(usernameInputBox.isDisplayed(),"veirfy that username is NOT displayed");
        // locate the start button
        WebElement startButton = driver.findElement(By.xpath("//div[@id='start']/button"));
        // click the start button
        startButton.click();
        // wait for 5 seconds to username boc to be displayed on the screen.
        Thread.sleep(5000);
        // verify that username is displayed.
        Assert.assertTrue(usernameInputBox.isDisplayed(),"verify that username is displayed");
    }
}
