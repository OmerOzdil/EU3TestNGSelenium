package com.cybertek.pages;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.jsoup.Connection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends BasePage  {

    @FindBy(xpath = "//h1[@class='user-name']")
    public WebElement name;

    @FindBy(xpath = "//a[@class='phone']")
    public WebElement phone;

    @FindBy(xpath = "//a[@class='email']")
    public WebElement email;

//    @FindBy(xpath = "//td[text()='mbrackstone9@example.com']")
//    public WebElement email1;



    public void clickonemail(String email) {
        WebElement element = Driver.get().findElement(By.xpath("//td[text()='"+email+"']"));
        BrowserUtils.waitForClickablility(element,5);
        element.click();

    }
}
