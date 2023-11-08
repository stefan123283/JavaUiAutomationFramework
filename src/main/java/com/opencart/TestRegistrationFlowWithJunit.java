package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import com.opencart.pageobjects.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestRegistrationFlowWithJunit {

    WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;

    @BeforeAll
    public static void executeThisMethodBeforeAllTheTests() {
        System.out.println("The execution of the test suite has started");
    }

    @BeforeEach
    public void executeTheCodeBeforeEachTest() {
        System.out.println("The code is executed before each test case");
        driver = DriverManager.getInstance().getDriver();
        driver.get("https://www.andreisecuqa.host/");
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        homePage.navigateToRegisterPageFromHeader();
    }

    @Test
    @DisplayName("The registration of a new user with valid data redirects to the Account Page")
    public void registerWithValidCredentialsTest() throws InterruptedException {
        System.out.println("This is the test number 1");

        String randomEmail = RandomDataManager.generateRandomEmail();
        System.out.println(randomEmail);

        String password = RandomDataManager.generatePassword();
        System.out.println(password);

        registerPage.fillInTheRegisterForm(RandomDataManager.generateFirstName(), RandomDataManager.generateLastName(), randomEmail, password, true);

        registerPage.clickTheContinueButton();

        Thread.sleep(500);
        String currentUrl = driver.getCurrentUrl();

        boolean doesTheCurrentUrlContainSuccessAccountRoute = driver.getCurrentUrl().contains("route=account/success");

        Assertions.assertTrue(doesTheCurrentUrlContainSuccessAccountRoute, "The current url contains:" + currentUrl + " route=account/success");
    }

    @Test
    @DisplayName("The user is remaining on Register page when trying to register with invalid password")
    public void registerWithInvalidPasswordTest() throws InterruptedException {

        String randomEmail = RandomDataManager.generateRandomEmail();
        System.out.println(randomEmail);

        registerPage.fillInTheRegisterForm(RandomDataManager.generateFirstName(), RandomDataManager.generateLastName(), randomEmail, "1", true);

        registerPage.clickTheContinueButton();

        Thread.sleep(500);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://andreisecuqa.host/index.php?route=account/register&language=en-gb";
        Assertions.assertEquals(expectedUrl, actualUrl, "The urls should be equals");
    }


    @Test
    @DisplayName("Error message is displayed on Register flow when password is less than 4 chars")
    public void errorMessageIsDisplayedWhenInvalidPasswordIsUsedForRegisterFlow() throws InterruptedException {

        String randomEmail = RandomDataManager.generateRandomEmail();
        System.out.println(randomEmail);

        registerPage.fillInTheRegisterForm(RandomDataManager.generateFirstName(), RandomDataManager.generateLastName(), randomEmail, "Aa1", true);

        registerPage.clickTheContinueButton();

        Thread.sleep(500);

        String actualErrorMessage = driver.findElement(By.id("error-password")).getText();
        String expectedErrorMessageForInvalidPassword = "Password must be between 4 and 20 characters!";
        Assertions.assertEquals(expectedErrorMessageForInvalidPassword, actualErrorMessage);
    }

    @AfterEach
    public void afterEachTestCase() {
        DriverManager.getInstance().tearDown();
        System.out.println("The test case execution has been finished");

    }

    @AfterAll
    public static void afterAllMethod() {
        System.out.println("The test suite execution is finished");
    }
}
