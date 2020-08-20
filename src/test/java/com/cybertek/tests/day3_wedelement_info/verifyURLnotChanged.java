package com.cybertek.tests.day3_wedelement_info;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLnotChanged {
    public static void main(String[] args) {
        /*Verify URL not changed
            -o pen browser
            - go to http://practice.cybertekschool.com/forgot_password Links to an external site.
            - click on Retrieve password
            - verify that url did not change
        */

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement retrieveButton = driver.findElement(By.id("form_submit"));
        retrieveButton.click();


    }
}
