package com.bw.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    //WebElements
    @FindBy(name = "usr")
    @CacheLookup
    private WebElement username;

    @FindBy(name = "pwd")
    @CacheLookup
    private WebElement password;

    @FindBy(id="case_login")
    @CacheLookup
    private WebElement submit;

    public LoginPage() {
        PageFactory.initElements((WebDriver) null, this);
    }

    //Methods
    public LoginPage login(String uName, String pWord){
        username.sendKeys(uName);
        password.sendKeys(pWord);
        submit.click();
        return this;
    }
}
