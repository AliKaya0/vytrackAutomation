package com.vytrack.tests;

import com.vytrack.pages.HomePage;
import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Us_6_CarIcon_view_delete_edit extends TestBase {

    @Test
    public void verify_3_dots (){
        //login to homepage
        VytrackUtils.loginAsStoreManager();

        //wait until homepage loads
        BrowserUtils.waituntilTitleDisplay("Dashboard");

        //creating the instance of the Homepage to call the locators
        HomePage homePage = new HomePage();

        //hover over fleetTab using Browserutils.hover method and then click on vehicles
        BrowserUtils.hover(homePage.fleetTab);
        homePage.vehicles.click();


        BrowserUtils.sleep(10);

        //wait until next page loads
        BrowserUtils.waituntilTitleDisplay("Entities");

        //hover over threedots

        BrowserUtils.hover(homePage.threeDots);

        //BrowserUtils.sleep(10);

        Assert.assertTrue(homePage.viewIcon.isDisplayed());
        Assert.assertTrue(homePage.editIcon.isDisplayed());
        Assert.assertTrue(homePage.deleteIcon.isDisplayed());





    }

}
