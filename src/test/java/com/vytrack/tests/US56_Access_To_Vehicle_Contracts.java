package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class US56_Access_To_Vehicle_Contracts {

    @Test
    public void AccessToVehContracts() throws InterruptedException {
        Point targetposition = new Point(0, 0);
        Driver.getDriver().manage().window().setPosition(targetposition);
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        VytrackUtils.loginAsDriver();

        //find fleet menu on homepage by xpath
        WebElement firstMenu = Driver.getDriver().findElement(By.xpath("//*[contains(text(), '    Fleet')]"));

        //move the mouse on fleet menu for drop dropdown submenu menu
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(firstMenu).build().perform();

        //checking if vehicle contracts is enabled and click it
        WebElement vehicleContractor = Driver.getDriver().findElement(By.xpath("//*[.=\'Vehicle Contracts\']"));
        Assert.assertTrue(vehicleContractor.isEnabled());
        vehicleContractor.click();

        //giving some time to browser to store the error on the page
        Thread.sleep(2000);

        //we store all errors in error displayed list
        List<WebElement> errorDisplayed = Driver.getDriver().findElements(By.className("message"));

        //we're checking if last error is displayed after vehicle contracts click
        Assert.assertTrue(errorDisplayed.get(errorDisplayed.size() - 1).isDisplayed());

        //we compare expected message with actual message
        String expectedResult = "You do not have permission to perform this action.";
        Assert.assertEquals(expectedResult, errorDisplayed.get(errorDisplayed.size() - 1).getText());


        WebElement profileMenu = Driver.getDriver().findElement(By.xpath("//*[@id='user-menu']/a/i"));
        WebElement logout = Driver.getDriver().findElement(By.xpath("//*[contains(text(), 'Logout')]"));


       profileMenu.click();
        logout.click();
        Driver.getDriver().manage().window().maximize();







            VytrackUtils.loginAsStoreManager();
            Thread.sleep(5000);

            WebElement firstMenu2 = Driver.getDriver().findElement(By.xpath("//*[contains(text(), '    Fleet')]"));

            WebElement vehicleContractor2 = Driver.getDriver().findElement(By.xpath("//*[.=\'Vehicle Contracts\']"));

            //Actions action = new Actions(Driver.getDriver());
            //move the mouse on fleet menu for drop dropdown submenu menu
            action.moveToElement(firstMenu2).build().perform();

            vehicleContractor2.click();
            String expectedTitle = "All - Vehicle Contract - Entities - System - Car - Entities - System";

            Thread.sleep(5000);


            BrowserUtils.verifyTitle(Driver.getDriver(), expectedTitle);


        }
    }
