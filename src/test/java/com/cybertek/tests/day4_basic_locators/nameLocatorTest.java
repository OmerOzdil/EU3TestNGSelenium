package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class nameLocatorTest {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullnameBox = driver.findElement(By.name("full_name"));
        fullnameBox.sendKeys("Mike Smith");

        WebElement emailBox = driver.findElement(By.name("email"));
        emailBox.sendKeys("omerozdil54@gmail.com");

        WebElement signUpBUtton = driver.findElement(By.name("wooden_spoon"));
        signUpBUtton.click();

        driver.quit();
    }
}
