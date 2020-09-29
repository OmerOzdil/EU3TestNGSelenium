package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashBoardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {


    /**
     * Test case
     * Open browser
     * Login as a Driver
     * Verify that page subtitle is Quick Launchpad
     * Go to Activities -> Calendar Events
     * verify that page subtitle is Calendar Events
     */
    @Test
    public void test1() throws InterruptedException {

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsDriver();

        String expectedSubTitle="Quick Launchpad";
        System.out.println("expectedSubTitle = " + expectedSubTitle);
        DashBoardPage dashBoardPage = new DashBoardPage();
        String actualSubTitle= dashBoardPage.getPageSubTitle();

        Assert.assertEquals(actualSubTitle,expectedSubTitle);

        loginPage.navigateToModule("Activities","Calendar Events");

        BrowserUtils.waitFor(1);
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        System.out.println(loginPage.getPageSubTitle());
        Assert.assertEquals(calendarEventsPage.getPageSubTitle(),"Calendar Events");

    }

}
