package com.cybertek.tests.day2_webdriver_basics;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {
    public static void main(String[] args) {
        
        WebDriver driver=WebDriverFactory.getDriver("chrome");

        driver.get("http://google.com");

        String title=driver.getTitle();

        System.out.println("title = " + title);

        driver.get("https://facebook.com");

        String title1 = driver.getTitle();

        System.out.println("title1 = " + title1);

        driver.close();

    }
}
