package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashBoardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class verifyTheInfo extends TestBase {

    /**
     * open the chrome
     * go to qa1.vytrack
     * login as a sales manager
     * navigate to customers ->contacts
     * click on email mbrackstone9@example.com
     * verify that full name is Mariam Brackstone
     * verify that email is mbrackstone9@example.com
     * verify that phone number is +18982323434
     */

    @Ignore
    @Test
    public void TC(){

        //Name the project
        extentLogger = report.createTest("Check Details");

        //create an object from LoginPage
        LoginPage loginPage = new LoginPage();
        extentLogger.info("Login as Sales Manager");

        //Login as SalesManager
        loginPage.loginAsSalesManager();

        //Create an object from The Dashboard.
        DashBoardPage dashBoardPage = new DashBoardPage();


        //Navigate to customer and Contact Page.
        dashBoardPage.navigateToModule("Customers","Contacts");
        //extentLogger.info("Navigate to the Contacts page");

        //create an object from the ContactPage
        ContactsPage contactsPage = new ContactsPage();


        // create an string of expected email.
        //use a different one to show it dynamic "mike.jorden@hotmail.com"
        String expectedEmail="mike.jorden@hotmail.com";
        //extentLogger.info("click on the "+expectedEmail);

        //create and expected string of name.
        //use a different one to show it dynamic "Mike Jorden"
        String expectedName="Mike Jorden";

        //creare an string of the expected phone number.
        //use a different one to show it dynamic "7790499876
        String expectedPhoneNumber="7790499876";

        //loading issue is overcome.
        BrowserUtils.waitFor(3);
        contactsPage.clickonemail(expectedEmail);


        //Make the assertions
        Assert.assertEquals(contactsPage.name.getText(),expectedName);
        //extentLogger.info("Th names are the same as following "+ expectedName+"="+contactsPage.name.getText());
        Assert.assertEquals(contactsPage.email.getText(),expectedEmail);
        //extentLogger.info("The emails are the same as following "+ expectedEmail+"="+ contactsPage.email.getText());
        Assert.assertEquals(contactsPage.phone.getText(),expectedPhoneNumber);
        //extentLogger.info("The phone numbers are the same as following "+ expectedPhoneNumber+"="+contactsPage.phone.getText());
        //extentLogger.info("Passed");

    }

}
