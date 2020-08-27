package com.cybertek.tests.day3_wedelement_info;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConformationMessage {
    public static void main(String[] args) {
        /*
        Verify confirmation message
            - open browser
            - go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
            - enter any email
            - verify that email is displayed in the input box
            - click on Retrieve password
            - verify that confirmation message says ‘Your e-mail’s been sent!’
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        // navigate the address
        driver.get("http://practice.cybertekschool.com/forgot_password");

        // locate the inputBox
        WebElement emailInputBox=driver.findElement(By.name("email"));

        // send an email
        emailInputBox.sendKeys("mike@smith.com");

        String expectedName="mike@smith.com";

        // retrieve the email sent.
        String actualName = emailInputBox.getAttribute("value");
        System.out.println("actualName = " + actualName);


        if(expectedName.equals(actualName)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }

        // locate the retrieve button
        WebElement retrievePasswordButton=driver.findElement(By.id("form_submit"));

        // click the retrieve button
        retrievePasswordButton.click();

        String expectedMessage="Your e-mail's been sent!";
        System.out.println("expectedMessage = " + expectedMessage);
        // locate the message
        WebElement message=driver.findElement(By.xpath("//h4[@name='confirmation_message']"));
        // get the message statement
        String actualMessage = message.getText();
        System.out.println("actualMessage =   " + actualMessage);

        //make a comparison.
        if(actualMessage.equals(expectedMessage)){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }
        driver.close();
    }
}
