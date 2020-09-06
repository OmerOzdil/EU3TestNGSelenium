package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class noSelectDropDown {


    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1(){

        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropDownElement = driver.findElement(By.id("dropdownMenuLink"));

        dropDownElement.click();
        // locate the dropdown oprions.
        List<WebElement> dropDownOptions = driver.findElements(By.xpath("//a[@class='dropdown-item']"));

        //print size of the dropdown.
        System.out.println("dropDwonOptions.size() = " + dropDownOptions.size());

        //print the options one by one.
        for (WebElement option: dropDownOptions){
            System.out.println(option.getText());

        }

    }
}


