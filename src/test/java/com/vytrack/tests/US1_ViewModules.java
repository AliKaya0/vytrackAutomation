package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US1_ViewModules {

    //testing modules for sales manager
    @Test
    public void verifying_modules_as_sales_manager() {
        VytrackUtils.loginAsSalesManager();
        List<WebElement> moduleElements = Driver.getDriver().findElements(By.xpath("//span[@class='title title-level-1']"));
        List<String> actualmoduleTexts = new ArrayList<>();

        for (WebElement moduleElement : moduleElements) {
            String moduleElementText = moduleElement.getText();
            actualmoduleTexts.add(moduleElementText);
        }

        List<String> expectedmoduleTexts = new ArrayList<>(Arrays.asList(
                "Dashboards",
                "Fleet",
                "Customers",
                "Sales",
                "Activities",
                "Marketing",
                "Reports & Segments",
                "System"));

        Assert.assertEquals(actualmoduleTexts, expectedmoduleTexts);




    }

    //testing modules for store manager
    @Test
    public void verifying_modules_as_store_manger(){
        VytrackUtils.loginAsStoreManager();
        List<WebElement> moduleElements = Driver.getDriver().findElements(By.xpath("//span[@class='title title-level-1']"));
        List<String> actualmoduleTexts = new ArrayList<>();

        for (WebElement moduleElement : moduleElements) {
            String moduleElementText = moduleElement.getText();
            actualmoduleTexts.add(moduleElementText);
        }

        List<String> expectedmoduleTexts=new ArrayList<>(Arrays.asList(
                "Dashboards",
                "Fleet",
                "Customers",
                "Sales",
                "Activities",
                "Marketing",
                "Reports & Segments",
                "System"));

        Assert.assertEquals(actualmoduleTexts, expectedmoduleTexts);



    }


    //testing modules for driver
    @Test
    public void verifiyng_modules_as_driver() {
        VytrackUtils.loginAsDriver();
        List<WebElement> moduleElements = Driver.getDriver().findElements(By.xpath("//span[@class='title title-level-1']"));
        List<String> actualmoduleTexts = new ArrayList<>();

        for (WebElement moduleElement : moduleElements) {
            String moduleElementText = moduleElement.getText();
            actualmoduleTexts.add(moduleElementText);
        }

        List<String> expectedmoduleTexts = new ArrayList<>(Arrays.asList(
                "Fleet",
                "Customers",
                "Activities",
                "System"));

        Assert.assertEquals(actualmoduleTexts, expectedmoduleTexts);


    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}


