package com.vytrack.tests;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US55_PinbarImage {

    @Test

    public void pinBarImageTest() {

        VytrackUtils.loginAsDriver();

        WebElement pinbarLink = Driver.getDriver().findElement(By.xpath("(//a[@title=\"How To Use Pinbar\"])[1]"));

        pinbarLink.click();

        WebElement pinbarImage = Driver.getDriver().findElement(By.xpath("//div[@class='clearfix']//img"));

        String actualImageSrc = pinbarImage.getAttribute("src");

        String expecteImageSrc = "https://qa1.vytrack.com/bundles/oronavigation/images/pinbar-location.jpg";

        Assert.assertEquals(actualImageSrc, expecteImageSrc);


    }

}
