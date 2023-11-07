package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import com.opencart.pageobjects.*;
import org.openqa.selenium.WebDriver;



public class TestRunnerWithPageObjects {
    public static void main(String[] args) {

        WebDriver driver = DriverManager.getInstance().getDriver();

        driver.get("https://www.andreisecuqa.host/");

        HomePage homePage = new HomePage(driver);

        homePage.navigateToRegisterPageFromHeader();

        RegisterPage registerPage = new RegisterPage(driver);

        String randomEmail = RandomDataManager.generateRandomEmail();
        System.out.println(randomEmail);

        String password = RandomDataManager.generatePassword();
        System.out.println(password);

        registerPage.fillInTheRegisterForm(RandomDataManager.generateFirstName(), RandomDataManager.generateLastName(), randomEmail, password, true);

        registerPage.clickTheContinueButton();

        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);

        accountCreatedPage.navigateToAccountPage();

        AccountPage accountPage = new AccountPage(driver);

        accountPage.logoutFromAccountPage();

        accountPage.navigateToHomePageFromAccountPage();

        homePage.navigateToLoginPageFromHeader();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.fillInTheLoginForm(randomEmail, password);

        loginPage.clickTheLoginBtn();

        accountPage.logoutFromAccountPage();

        DriverManager.getInstance().tearDown();

        System.out.println("The execution is over");

    }

}