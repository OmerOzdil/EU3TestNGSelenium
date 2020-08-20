package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    //Task:
    //Write a static method that takes a string parameter name: browserType
    // based on the value if parameter
    //it will setup the browser and
    // the method
    // will return chromedriver or firefoxdiver object.

    public static WebDriver getDriver(String browserType){

        String browser= browserType;
        WebDriver driver= null;

        switch(browser.toLowerCase()){

            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver= new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

        }
        return driver;

    }
}
