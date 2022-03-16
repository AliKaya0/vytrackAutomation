package com.vytrack.tests;

import com.vytrack.pages.ActivityPage;
import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Us_Create_Recurring extends TestBase {

   @Test
   public void create_activity() {


      VytrackUtils.loginAsStoreManager();

      ActivityPage activityPage = new ActivityPage();

      BrowserUtils.waituntilTitleDisplay("Dashboard");

      BrowserUtils.hover(activityPage.activity);
      activityPage.calenderEvent.click();



      BrowserUtils.sleep(5);

      //wait until next page loads
      BrowserUtils.waituntilTitleDisplay("Calendar Events");

      activityPage.createCalender.click();
      BrowserUtils.waituntilTitleDisplay("Calendar event");

      activityPage.repaetcheck.click();


      String expectedResult = "1";
      String actualResult = activityPage.repeatEveryInputBox.getAttribute("value");

      Assert.assertTrue(expectedResult.equals(actualResult));







      BrowserUtils.sleep(5);


   }

   @Test
   public void clear_the_repat_day_and_see_an_error_message () {


      VytrackUtils.loginAsSalesManager();

      ActivityPage activityPage = new ActivityPage();

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


      String expectedResult = "This value should not be blank.";
      String actualResult = activityPage.errorMessage.getText();

      System.out.println("actualResult = " + actualResult);
      System.out.println("expectedResult = " + expectedResult);

      Assert.assertTrue(expectedResult.equals(actualResult));


      //BrowserUtils.hover(activityPage.calenderEvent);

      BrowserUtils.sleep(2);


   }


}