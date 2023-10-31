package com.opencart;

import com.opencart.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentWindowName = driver.getWindowHandle();

        //New Window Code
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.close();

        driver.switchTo().window(currentWindowName);
        driver.get("https://tekwill.md/");
        System.out.println(driver.getTitle());
        driver.quit();

        System.out.println("The execution is over");

    }
}