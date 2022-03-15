package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class US54_AccessToOroincDocumentationPage {

    @Test
    public void step1() {
        VytrackUtils.loginAsDriver();

        // Find Question Icon webElement
        WebElement questionIcon = Driver.getDriver().findElement(By.xpath("//i[@class='fa-question-circle']"));

        // Check if Question Icon is displayed
        Assert.assertTrue(questionIcon.isDisplayed());

        //Click Question Icom
        questionIcon.click();




    for (String handle : Driver.getDriver().getWindowHandles()) {
        Driver.getDriver().switchTo().window(handle);
    }


        System.out.println(Driver.getDriver().getCurrentUrl());






    String ExpectedUrl = "https://doc.oroinc.com/";
    String ActualURL = Driver.getDriver().getCurrentUrl();

    Assert.assertEquals(ExpectedUrl, ActualURL);
 //

}
}




