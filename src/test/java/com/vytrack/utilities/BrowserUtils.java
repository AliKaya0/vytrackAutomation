package com.vytrack.utilities;

/*
In this class only general utility method that are not related to some specific page
 */


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {

    /*
    This method will accept int (in seconds) and execute Thread.sleep for given duration
     */


    public static void  sleep (int second) {
              second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }

    }

/*
This method accepts 3 arguments.
    Arg1: webdriver
    Arg2: expectedInUrl : for verify if the url contains given String.
        - If condition matches, will break loop.
    Arg3: expectedInTitle to be compared against actualTitle
at line 40
 */


    public static void switchWindowAndVerify(WebDriver driver, String expectedInURL,String expectedTitle){

        Set<String> allWindowsHandles = driver.getWindowHandles();

        for (String each : allWindowsHandles) {

            driver.switchTo().window(each);

            System.out.println("Current URL: " + driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains(expectedInURL)){
                break;
            }

        }

        //5. Assert: Title contains “expectedTitle”
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    /*
    This method accept a string "expectedTittle" and Assert if it is true
     */
    public static void verifyTitle(WebDriver driver, String expectedTitle){

        Assert.assertEquals(driver.getTitle(), expectedTitle);

    }

    //Create hover(WebElement element) method
    public static void hover (WebElement element){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).pause(3).perform();
    }

    //Create scrollToElement(WebElement element) method
    public static void scrollToElement(WebElement element1) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //indexes:  0
        js.executeScript("arguments[0].scrollIntoView(true);", element1);

    }

    //Create waituntilTitleDisplay(String title) method
    public static void waituntilTitleDisplay(String title) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        //if contains it is enough
        wait.until(ExpectedConditions.titleContains(title));
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 /*   //exact matching
    wait.until(ExpectedConditions.titleIs(title));
  */
    }

    //Create waituntilInvisibilityOfElement(WebElement element,int timeout) method
    public static void waituntilInvisibilityOfElement(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }


}
/*
1. Create a new class called BrowserUtils
2. Create a method to make Task1 logic re-usable
3. When method is called, it should switch window and verify title.


Method info:
• Name: switchWindowAndVerify
• Return type: void
• Arg1: WebDriver
• Arg2: String expectedInUrl
• Arg3: String expectedTitle
 */