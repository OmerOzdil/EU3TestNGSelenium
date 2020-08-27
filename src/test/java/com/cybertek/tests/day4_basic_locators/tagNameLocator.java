package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tagNameLocator {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInputBox = driver.findElement(By.tagName("input"));

        fullNameInputBox.sendKeys("Mike Smith");

        WebElement emailBox = driver.findElement(By.name("email"));

        emailBox.sendKeys("MikeSmith@gmail.com");

        driver.findElement(By.tagName("button")).click();
        driver.close();
    }
}
