package com.cybertek.tests.day2_webdriver_basics;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Practice {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        String url= driver.getCurrentUrl();
        System.out.println("url = " + url);

        WebElement retrieve_password = driver.findElement(By.xpath("//button[@id='form_submit']"));
        retrieve_password.click();

        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);
        if(url.equalsIgnoreCase(currentUrl)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        driver.close();

    }
}
