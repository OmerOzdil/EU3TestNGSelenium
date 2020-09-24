package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongPasswordTest(){

        LoginPage loginpage = new LoginPage();

        loginpage.usernameInput.sendKeys("user1");
        loginpage.passwordInput.sendKeys("somepassword");
        loginpage.loginButton.click();


        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

    }
    @Test
    public void wrongUsernameTest(){

        LoginPage loginpage = new LoginPage();

        loginpage.usernameInput.sendKeys("username");
        loginpage.passwordInput.sendKeys("UserUser123");
        loginpage.loginButton.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
    }
}
