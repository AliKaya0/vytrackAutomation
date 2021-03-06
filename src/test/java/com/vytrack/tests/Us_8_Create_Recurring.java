package com.vytrack.tests;

import com.vytrack.pages.US8ActivityPage;
import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Us_8_Create_Recurring extends TestBase {

   @Test
   public void create_activity() {

      // user on the home page
      VytrackUtils.loginAsStoreManager();

      //creating the instance of the activity to call the locators
      US8ActivityPage activityPage = new US8ActivityPage();

      BrowserUtils.waituntilTitleDisplay("Dashboard");

      //hover over activitytab using Browserutils.hover method and then click on vehicles
      BrowserUtils.hover(activityPage.activity);
      activityPage.calenderEvent.click();


      //wait until next page loads
     // BrowserUtils.sleep(5);

      //wait until next page loads
      BrowserUtils.waituntilTitleDisplay("Calendar Events");

      activityPage.createCalender.click();
      BrowserUtils.waituntilTitleDisplay("Calendar event");

      //check the repeat button
      activityPage.repaetcheck.click();

      //verify number 1 is display
      String expectedResult = "1";
      String actualResult = activityPage.repeatEveryInputBox.getAttribute("value");

      Assert.assertTrue(expectedResult.equals(actualResult));







      BrowserUtils.sleep(5);


   }

   @Test
   public void clear_the_repat_day_and_see_an_error_message () {


      VytrackUtils.loginAsSalesManager();

      US8ActivityPage activityPage = new US8ActivityPage();

      BrowserUtils.waituntilTitleDisplay("Dashboard");

      BrowserUtils.hover(activityPage.activity);
      activityPage.calenderEvent.click();

      //BrowserUtils.sleep(5 );

      //wait until next page loads
      BrowserUtils.waituntilTitleDisplay("Calendar Events");

      activityPage.createCalender.click();
      BrowserUtils.waituntilTitleDisplay("Calendar event");

      activityPage.repaetcheck.click();


      activityPage.repeatEveryInputBox.sendKeys(Keys.BACK_SPACE + ""+Keys.ENTER);

      //verify error message
      String expectedResult = "This value should not be blank.";
      String actualResult = activityPage.errorMessage.getText();

      System.out.println("actualResult = " + actualResult);
      System.out.println("expectedResult = " + expectedResult);

      Assert.assertTrue(expectedResult.equals(actualResult));




      BrowserUtils.sleep(2);


   }


}