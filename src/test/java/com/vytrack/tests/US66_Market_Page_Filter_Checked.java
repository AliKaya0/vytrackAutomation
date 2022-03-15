package com.vytrack.tests;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class US66_Market_Page_Filter_Checked {

    @Test

    public void AllCheckedTest() {
        VytrackUtils.loginAsStoreManager();

        Actions actions = new Actions(Driver.getDriver());
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='nav-multilevel main-menu']/li[6]")));
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//ul[@class='nav-multilevel main-menu']/li[6]"))).perform();

        Driver.getDriver().findElement(By.xpath("(//span[text()='Campaigns'])[1]")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='column-manager dropdown']//a")));
        Driver.getDriver().findElement(By.xpath("//div[@class='column-manager dropdown']//a")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//tbody[@class='ui-sortable']//td[3]/input")));
        List<WebElement> listOfBoxes = Driver.getDriver().findElements(By.xpath("//tbody[@class='ui-sortable']//td[3]/input"));

        for (WebElement box : listOfBoxes) {
            Assert.assertTrue(box.isSelected());
        }


    }


}
