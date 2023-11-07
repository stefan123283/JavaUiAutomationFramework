package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Page{
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")

    private WebElement logoutBtn;

    @FindBy(xpath = "//a[@class='btn btn-primary']")

    private WebElement continueBtn;

    public void logoutFromAccountPage(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        myAccountIcon.click();
        logoutBtn.click();
    }

    public void navigateToHomePageFromAccountPage(){
        continueBtn.click();
    }
}
