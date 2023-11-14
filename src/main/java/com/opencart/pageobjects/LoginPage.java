package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-email']")

    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='input-password']")

    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")

    private WebElement loginBtn;

    public void fillInTheLoginForm(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
    }

}
