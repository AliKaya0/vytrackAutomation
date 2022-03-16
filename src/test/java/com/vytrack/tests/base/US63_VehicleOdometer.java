package com.vytrack.tests.base;


import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US63_VehicleOdometer extends TestBase {




    @Test
    public void verifyAsStoreManager( ) {
        VytrackUtils.loginAsStoreManager();

        BrowserUtils.sleep(5);
        Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[2]")).click();

        Driver.getDriver().findElement(By.xpath("//span[.='Vehicle Odometer']")).click();

        String errorMessage = Driver.getDriver().findElement(By.xpath("//div[.='You do not have permission to perform this action.']")).getText();

        System.out.println("actualText = " + errorMessage);

        String expectedErrorMessage = "You do not have permission to perform this action.";

        System.out.println("expectedText = " + expectedErrorMessage);

        Assert.assertEquals(errorMessage,expectedErrorMessage,"Text did not match");




    }

    @Test
    public void verifyAsDriver() {
        VytrackUtils.loginAsDriver();


//        VytrackLoginPage loginPage = new VytrackLoginPage();
//        loginPage.goToLoginPage();
//
//        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("driver_username"));
//        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("driver_password"));
//        loginPage.loginButton.click();


        Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[1]")).click();

        Driver.getDriver().findElement(By.xpath("//span[.='Vehicle Odometer']")).click();

        String defaultPageValue = Driver.getDriver().findElement(By.xpath("//input[@value='1']")).getAttribute("value");

        String expectedDefaultPageValue = "1";

        Assert.assertEquals(defaultPageValue,expectedDefaultPageValue);

        System.out.println("actualValue = " + defaultPageValue);

        System.out.println("expectedValue = " + expectedDefaultPageValue);

        String viewPerPageValue = Driver.getDriver().findElement(By.xpath("//button[@class='btn dropdown-toggle ']")).getText();

        System.out.println("actualValue2 = " + viewPerPageValue);

        String expectedViewPerPageValue = "25";

        System.out.println("expectedValue2 = " + expectedViewPerPageValue);

        Assert.assertEquals(viewPerPageValue, expectedViewPerPageValue);





    }
}

