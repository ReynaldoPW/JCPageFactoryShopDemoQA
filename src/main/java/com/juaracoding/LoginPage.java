package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "/html/body/p/a")
    WebElement dismissButton;

    @FindBy(xpath = "//*[@id=\"noo-site\"]/header/div[1]/div/ul[2]/li[2]/a")
    WebElement myAccountLink;

    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(name = "login")
    WebElement loginButton;

    public void clickDismissButton(){
        dismissButton.click();
    }

    public void clickMyAccountLink(){
        myAccountLink.click();
    }

    public void Login(String username,String password){
        this.username.sendKeys("reypau");
        this.password.sendKeys("formeonly123");
        loginButton.click();
    }
}