package com.cybertek.tests.day7_testng;

import org.testng.annotations.*;

public class BeforeAfterMethod {

    @BeforeClass
    public void setUpClass() {
        System.out.println("BEFORE CLASS");
        System.out.println("executed one time before class");
    }
    @AfterClass
    public void tearDownClas(){
        System.out.println("AFTER CLASS");
        System.out.println("executed one time after class");

    }

    @Test
    public void test1(){
        System.out.println("First Test Case");
    }
    //@Ignore
    @Test
    public void test2(){
        System.out.println("Second Test Case");
    }
    @Test
    public void test3(){
        System.out.println("Third Test Case");
    }
    @BeforeMethod
    public void setUp(){
        System.out.println("WebDriver,Opening Browser");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("Browser Closing, Quit");
    }
}
