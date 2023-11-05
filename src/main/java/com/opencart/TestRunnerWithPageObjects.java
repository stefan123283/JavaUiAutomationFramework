package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TestRunnerWithPageObjects {
    public static void main(String[] args) throws InterruptedException {

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

        DriverManager.getInstance().tearDown();

        System.out.println("The execution is over");

    }

}