package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id ="prependedInput")
    public WebElement usernameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginButton;


    public void login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void loginAsStoreManager(){
        usernameInput.sendKeys(ConfigurationReader.get("storemanager_username"));
        passwordInput.sendKeys(ConfigurationReader.get("storemanager_password"));
        loginButton.click();
    }
    public void loginAsDriver(){
        usernameInput.sendKeys(ConfigurationReader.get("driver_username"));
        passwordInput.sendKeys(ConfigurationReader.get("driver_password"));
        loginButton.click();
    }

}
