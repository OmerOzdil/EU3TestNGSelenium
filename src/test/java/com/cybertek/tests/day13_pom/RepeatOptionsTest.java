package com.cybertek.tests.day13_pom;

import com.cybertek.pages.*;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTest extends TestBase {
     /*VERIFY RADIO BUTTONS
    Open browser
    Login as driver
    Go to Activities->Calendar Events
    Click on create calendar events
    Click on repeat
    Verify that repeat every days is checked
    verify that repeat weekday is not checked
    * */

    @Test
    public void test1(){
        LoginPage loginPage = new LoginPage();
        //Login as driver
        loginPage.loginAsDriver();

        DashBoardPage dashboardPage = new DashBoardPage();
        //Go to Activities->Calendar Events
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        //Click on create calendar events
        //wait for loader mask
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForClickablility(calendarEventsPage.createCalendarEvent,5);
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        // Click on repeat
        createCalendarEventsPage.repeat.click();

        //Verify that repeat every days is checked
        Assert.assertTrue(createCalendarEventsPage.days.isSelected(),"Verify repeat days is selected");
        //verify that repeat weekday is not checked
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(),"Verify weekday is not selected");

    }

      /*
   VERIFY REPEAT OPTIONS
   Open browser
   Login as driver
   Go to Activities->Calendar Events
   Click on create calendar events button
   Click on repeat checkbox
   Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
   */
    @Test
    public void test2(){

    LoginPage loginPage = new LoginPage();
    loginPage.loginAsDriver();

    loginPage.navigateToModule("Activities","Calendar Events");

    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    calendarEventsPage.waitUntilLoaderScreenDisappear();
    BrowserUtils.waitFor(3);
    calendarEventsPage.createCalendarEvent.click();

    CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();

    createCalendarEventsPage.repeat.click();


    //create a select method by using a ready locator from the createCalendarEventsPage
    Select options = createCalendarEventsPage.repeatOptionsList();

        System.out.println(options.getFirstSelectedOption().getText());

        List<String> expectedOptions= Arrays.asList("Daily","Weekly","Monthly","Yearly");

    List<String> actualList = new ArrayList<>();

    //get the each webelements from options select object.
    List<WebElement> options1 = options.getOptions();

    // ready method to get the text of elements and add to them in List<String>
    List<String> elementsText = BrowserUtils.getElementsText(options1);
    System.out.println(elementsText.toString());
    System.out.println("******************");


    for (WebElement option:options1) {
         System.out.println(option.getText());
         // get the text of each element and add it to actualList
         actualList.add(option.getText());
        }
    Assert.assertEquals(actualList,expectedOptions);
    }
}
