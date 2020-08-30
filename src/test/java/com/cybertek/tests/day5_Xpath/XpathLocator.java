package com.cybertek.tests.day5_Xpath;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathLocator {
    public static void main(String[] args) {

        WebDriver driver =WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.co.uk/");
        WebElement element = driver.findElement(By.xpath("//div/h2[contains(text(),'Shop deals')]"));

        System.out.println("element.getText() = " + element.getText());
    }
}
