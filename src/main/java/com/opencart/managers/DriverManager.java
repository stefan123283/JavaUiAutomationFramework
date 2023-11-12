package com.opencart.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {
    private static String webDriverType = "Edge";
    private static DriverManager instance;
    private WebDriver driver;

    private DriverManager() {
        switch (webDriverType.toUpperCase()) {
            case "CHROME":
                driver = new ChromeDriver();
                System.out.println("The Chrome Driver is initiated");
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                System.out.println("The Firefox Driver is initiated");
                break;
            case "EDGE":
                EdgeOptions options = new EdgeOptions();
//                options.addArguments("user-data-dir=C:\\Users\\Frunza Stefan\\AppData\\Local\\Microsoft\\Edge\\User Data");
//                options.addArguments("profile-directory=Default");
                options.addArguments("ignore-certificate-errors");
                options.addArguments("--start-maximized");
                options.addArguments("--incognito");
                driver = new EdgeDriver(options);
                System.out.println("The Edge Driver is initiated");
                break;
            case "SAFARI":
                driver = new SafariDriver();
                System.out.println("The Safari Driver is initiated");
                break;
            default:
                System.out.println("There is not such a browser " + webDriverType);
        }
    }

    public static DriverManager getInstance(){
        if (instance == null){
            instance = new DriverManager();
        }
        return instance;
    }

    public void tearDown(){
        driver.close();
        driver.quit();
        instance = null;
        driver = null;
    }

    public void deleteAllCookies(){
        driver.manage().deleteAllCookies();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public WebDriver getDriver(){
        return driver;
    }

}
