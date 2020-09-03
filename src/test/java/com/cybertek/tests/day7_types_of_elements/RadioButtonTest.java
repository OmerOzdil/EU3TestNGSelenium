package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RadioButtonTest {

    @Test
    public void test1(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioButton = driver.findElement(By.id("blue"));
        WebElement redRadioButton = driver.findElement(By.id("red"));



        Assert.assertTrue(blueRadioButton.isSelected(),"verify that blue is seleceted");
        Assert.assertFalse(redRadioButton.isSelected(),"verify that red is NOT selected");

        // click red Radio Button.
        redRadioButton.click();


        Assert.assertFalse(blueRadioButton.isSelected(),"verify that blue is seleceted");
        Assert.assertTrue(redRadioButton.isSelected(),"verify that red is NOT selected");

    }

}
