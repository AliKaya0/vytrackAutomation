package com.vytrack.tests;


import com.vytrack.page.UserCanSelectVehicle;
import com.vytrack.page.Vehicle;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class US59_User_should_be_able_to_select_vehicle {

    @Test
    public void UserCanSelectVehicle() {
        //login as a sales manager
        //US
        VytrackUtils.loginAsSalesManager();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        UserCanSelectVehicle selectVehicle = new UserCanSelectVehicle();
        //go to FleetTab
        String fleetTabElementLocator = "//span[normalize-space()='Fleet' and contains(@class, 'title title-level-1')]";

        WebElement fleetTabElement = Driver.getDriver().findElement(By.xpath(fleetTabElementLocator));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleetTabElement).perform();
        String vehicle = "//span[normalize-space()='Vehicles' and contains(@class,'title title-level-2')]";
        WebElement vehicleTab = Driver.getDriver().findElement(By.xpath(vehicle));
        vehicleTab.click();


      List<WebElement> checkboxes = Driver.getDriver().findElements(By.xpath("//td/input[@type='checkbox']"));




      System.out.println(checkboxes.size());

        for (WebElement each : checkboxes)
        {
            Assert.assertFalse(each.isSelected());
        }





        }




    @Test
    public void testFirstCheckBox() {
        //AC #2: user check the first checkbox to check all the cars

        //login as a sales manager
        VytrackUtils.loginAsSalesManager();
        VytrackUtils.

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        UserCanSelectVehicle selectVehicle = new UserCanSelectVehicle();

        Actions actions = new Actions(Driver.getDriver());

        // Go to Vehicle page
        BrowserUtils.sleep(10);
        actions.moveToElement(selectVehicle.fleetTab).perform();
        BrowserUtils.sleep(10);

        selectVehicle.vehiclesTab.click();


        //click first checkbox
        //actions.moveToElement(selectVehicle.firstCheckbox).perform();
        selectVehicle.firstCheckbox.click();
        BrowserUtils.sleep(10);

        // Validate if all other checkboxes are selected
        for (WebElement carCheckbox : selectVehicle.carCheckboxes) {
            Assert.assertTrue(carCheckbox.isSelected());
        }
    }
    @Test
    public void selectRandomCars(){

        //login as a sales manager
        VytrackUtils.loginAsSalesManager();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        UserCanSelectVehicle selectVehicle = new UserCanSelectVehicle();

        Actions actions = new Actions(Driver.getDriver());

        // Go to Vehicle page
        BrowserUtils.sleep(10);
        actions.moveToElement(selectVehicle.fleetTab).perform();
        BrowserUtils.sleep(10);

        selectVehicle.vehiclesTab.click();
        // Select random car
        int random = (int) (Math.random()*(20)) + 1;

        WebElement randomCheckbox = Driver.getDriver().findElement(By.xpath("//tr["+random+"]//td//input[@type='checkbox']"));

        wait.until(ExpectedConditions.visibilityOf(randomCheckbox));
        BrowserUtils.sleep(10);
        randomCheckbox.click();
        Assert.assertTrue(randomCheckbox.isSelected());


    }
}


