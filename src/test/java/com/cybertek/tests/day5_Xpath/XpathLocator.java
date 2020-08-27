package com.cybertek.tests.day5_Xpath;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XpathLocator {
    public static void main(String[] args) {

        WebDriver driver =WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        driver.findElement(By.xpath("//button[@onclick='button1()']")).click();
    }
}
