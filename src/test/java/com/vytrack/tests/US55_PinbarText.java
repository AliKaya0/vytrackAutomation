package com.vytrack.tests;

import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US55_PinbarText {

    @Test

    public void pinBarImageTest() {

        VytrackUtils.loginAsDriver();

        WebElement pinbarLink = Driver.getDriver().findElement(By.xpath("(//a[@title=\"How To Use Pinbar\"])[1]"));

        pinbarLink.click();

        WebElement message1 = Driver.getDriver().findElement(By.xpath("//div[@class='clearfix']//h3"));

        String actualMessage1 = message1.getText();
        String expectedMessage1 = "How To Use Pinbar";

        Assert.assertEquals(actualMessage1, expectedMessage1);

        WebElement message2 = Driver.getDriver().findElement(By.xpath("(//div[@class='clearfix']//p)[1]"));

        String actualMessage2 = message2.getText();
        String expectedMessage2 = "Use pin icon on the right top corner of page to create fast access link in the pinbar.";

        Assert.assertEquals(actualMessage2, expectedMessage2);



    }
}