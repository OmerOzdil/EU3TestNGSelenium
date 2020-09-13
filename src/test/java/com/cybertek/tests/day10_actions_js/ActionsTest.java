package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionsTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.quit();
    }
    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.tagName("img"));

        // Actions--> class that contains all user interactions
        // pass the driver as an constructor.
        Actions actions = new Actions(driver);

        Thread.sleep(2000);
        //perform()--> perform the action complete the action.
        //moveElement()--> mover yout mouse to hover over the given element.
        actions.moveToElement(img1).perform();

        WebElement viewLink = driver.findElement(By.linkText("View profile"));

        // verify that view link is seen when the mouse is on it.
        Assert.assertTrue(viewLink.isDisplayed(),"verify view link is displayed.");

    }
    @Test
     public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        Actions actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        driver.findElement(By.xpath("//*[.='Accept and Close']")).click();

        /*Thread.sleep(2000);
        actions.dragAndDrop(source,target).perform();
         */
        Thread.sleep(1000);
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().build().perform();
    }

}
