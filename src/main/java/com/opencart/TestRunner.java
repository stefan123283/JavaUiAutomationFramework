package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.RandomDataManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentWindowName = driver.getWindowHandle();

        //New Window Code
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://opencart.antropy.co.uk/");

        WebElement myAccountIcon = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        myAccountIcon.click();

        WebElement registerOption = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registerOption.click();

        System.out.println(driver.getCurrentUrl());

        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));

        String firstName = RandomDataManager.generateFirstName();

        firstNameInput.sendKeys(firstName);

        System.out.println(firstName);

        WebElement lastNameInput = driver.findElement(By.cssSelector("#input-lastname"));

        String lastName = RandomDataManager.generateLastName();

        lastNameInput.sendKeys(lastName);

        System.out.println(lastName);

        WebElement emailInput = driver.findElement(By.cssSelector("#input-email"));

        String randomEmail = RandomDataManager.generateRandomEmail();

        emailInput.sendKeys(randomEmail);

        System.out.println(randomEmail);

        WebElement phoneInput = driver.findElement(By.cssSelector("#input-telephone"));

        phoneInput.sendKeys(RandomDataManager.generatePhoneNumber());

        WebElement passwordInput = driver.findElement(By.cssSelector("#input-password"));

        String password = RandomDataManager.generatePassword();

        passwordInput.sendKeys(password);

        System.out.println(password);

        WebElement confirmPasswordInput = driver.findElement(By.cssSelector("#input-confirm"));

        confirmPasswordInput.sendKeys(password);

        WebElement termsAndConditionsCheckbox = driver.findElement(By.xpath("//input[@name='agree']"));

        termsAndConditionsCheckbox.click();

        WebElement registerBtn = driver.findElement(By.xpath("//input[@value='Continue']"));

        registerBtn.click();

        System.out.println(driver.getTitle());
        driver.close();
        driver.quit();
        System.out.println("The execution is over");

    }
}