package com.cybertek.tests.day16_ddf;

import com.cybertek.pages.DashBoardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {

    @DataProvider
    public Object[][] userData(){
        ExcelUtil qa3Short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");

        String [][] dataArray= qa3Short.getDataArrayWithoutFirstRow();

        return dataArray;

    }

    @Test(dataProvider = "userData")
    public void test1(String username, String password, String firstname, String lastname){

        extentLogger = report.createTest("Test "+firstname+" "+lastname);
        LoginPage loginPage =new LoginPage();
        loginPage.login(username,password);

        DashBoardPage dashBoardPage = new DashBoardPage();
        dashBoardPage.waitUntilLoaderScreenDisappear();

        String actualFullName = dashBoardPage.getUserName();
        String expectedFullname=firstname+" "+lastname;

        Assert.assertEquals(expectedFullname,actualFullName);
        extentLogger.pass("PASSED");


    }

}
