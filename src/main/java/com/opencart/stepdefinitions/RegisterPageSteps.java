package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class RegisterPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @When("the register form is populated with valid random data")
    public void theRegisterFormIsPopulatedWithValidRandomData() {
        String randomEmail = RandomDataManager.generateRandomEmail();
        System.out.println(randomEmail);

        String password = RandomDataManager.generatePassword();
        System.out.println(password);

        registerPage.fillInTheRegisterForm(RandomDataManager.generateFirstName(), RandomDataManager.generateLastName(), randomEmail, password, true);

        System.out.println("The register form is populated with valid random data");

    }

    @And("Continue button is clicked")
    public void continueButtonIsClicked() {
        registerPage.clickTheContinueButton();
        System.out.println("The continue button has been clicked");
    }
}
