package com.vytrack.utilities;

import org.openqa.selenium.By;

public class VytrackUtils {

    public static void login(String username, String password){

        // Go to website --> pass username --> pass password --> click login button
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));

        Driver.getDriver().findElement(By.id("prependedInput")).sendKeys(username);

        Driver.getDriver().findElement(By.id("prependedInput2")).sendKeys(password);

        Driver.getDriver().findElement(By.id("_submit")).click();

    }

    public static void loginAsDriver(){

        // Go to website --> pass username --> pass password --> click login button
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));

        Driver.getDriver().findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.getProperty("driver_username"));

        Driver.getDriver().findElement(By.id("prependedInput2")).sendKeys(ConfigurationReader.getProperty("driver_password"));

        Driver.getDriver().findElement(By.id("_submit")).click();

    }

    public static void loginAsStoreManager(){

        // Go to website --> pass username --> pass password --> click login button
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));

        Driver.getDriver().findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.getProperty("store_manager_username"));

        Driver.getDriver().findElement(By.id("prependedInput2")).sendKeys(ConfigurationReader.getProperty("store_manager_password"));

        Driver.getDriver().findElement(By.id("_submit")).click();

    }

    public static void loginAsSalesManager(){

        // Go to website --> pass username --> pass password --> click login button
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));

        Driver.getDriver().findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.getProperty("sales_manager_username"));

        Driver.getDriver().findElement(By.id("prependedInput2")).sendKeys(ConfigurationReader.getProperty("sales_manager_password"));

        Driver.getDriver().findElement(By.id("_submit")).click();

    }


}
