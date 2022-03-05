package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    // Creating a private constructor, so we are closing access to object of this class from outside the class
    private Driver(){}

    // We make webDriver private because we want to close access from outside the class
    // We make is static because we will use it in a static method
    private static WebDriver driver;

    // Create a re-usable utility method which will return same driver instance when we call it
    public static WebDriver getDriver(){

        if (driver == null){

            // We read/get our browser type from configuration.properties. This way we can control which browser is opened from outside our code from configuration.properties
            String browserType =ConfigurationReader.getProperty("browser");


            // Depending on the browser type that will be return configuration.properties file switch statement will determine the case, and open the matching browser
            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.chromedriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }

        }

        return driver;


    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    // driver.quit() --> NoSuchElement


}
