package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashBoardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
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

    @Test
    public void test1(){

        extentLogger = report.createTest("Check details");

        LoginPage loginPage = new LoginPage();
        extentLogger.info("Login as Sales Manager");
        loginPage.loginAsSalesManager();

        DashBoardPage dashBoardPage = new DashBoardPage();


        extentLogger.info("Navigate to the Contacts page");
        dashBoardPage.navigateToModule("Customers","Contacts");

        ContactsPage contactsPage = new ContactsPage();


        String expectedEmail="mike.jorden@hotmail.com";
        extentLogger.info("click on the "+expectedEmail);
        String expectedName="Mike Jorden";
        String expectedPhoneNumber="7790499876";

        BrowserUtils.waitFor(3);
        contactsPage.clickonemail(expectedEmail);

        Assert.assertEquals(contactsPage.name.getText(),expectedName);
        extentLogger.info("name is the same");
        Assert.assertEquals(contactsPage.email.getText(),expectedEmail);
        extentLogger.info("email is the same");
        Assert.assertEquals(contactsPage.phone.getText(),expectedPhoneNumber);
        extentLogger.info("phone number is the same");
        extentLogger.info("Passed");

    }

}
