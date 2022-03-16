package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class ActivityPage {
     public ActivityPage() {

          PageFactory.initElements(Driver.getDriver(), this);
     }

     @FindBy(linkText = "Activities")
     public WebElement activity;

     @FindBy(linkText = "Calendar Events")
     public WebElement calenderEvent;

     @FindBy(xpath = "//*[@id=\"container\"]/div[2]/div/div/div[2]/div/a")
     public WebElement createCalender;

     @FindBy(xpath = "//input[contains(@id,\"recurrence-repeat-view\")]")
     //xpath = "//input[@id='recurrence-repeat-view430']"
     public WebElement repaetcheck;

     @FindBy (xpath = "(//input[@class=\'recurrence-subview-control__number\'])[1]")
     public WebElement repeatEveryInputBox;

     @FindBy (xpath = "(//span[.='This value should not be blank.'])[5]")
     public WebElement errorMessage;


}







