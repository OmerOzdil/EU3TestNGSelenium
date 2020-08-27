package com.cybertek.tests.day3_wedelement_info;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;

public class verifyUrlChanged {
    public static void main(String[] args) {
        /*
        Verify URL changed
            - open browser
            - go to http://practice.cybertekschool.com/forgot_password Links to an external site.
            - enter any email
            - click on Retrieve password
            - verify that url changed to http://practice.cybertekschool.com/email_sent
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement emailInputBox=driver.findElement(By.name("email"));
        emailInputBox.sendKeys("mike@smith.com");


        String expectedUrl=driver.getCurrentUrl();
        System.out.println("expectedUrl = " + expectedUrl);

        WebElement retrievePasswordButton=driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();


        String actualUrl=driver.getCurrentUrl();
        System.out.println("actualUrl = " + actualUrl);

        if(!expectedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
    }
}
