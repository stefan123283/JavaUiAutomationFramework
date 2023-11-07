package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends Page{

    public AccountCreatedPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//a[@class='btn btn-primary']")

    private WebElement continueBtn;



    public void navigateToAccountPage(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        continueBtn.click();
    }
}
