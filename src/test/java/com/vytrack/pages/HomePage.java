package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage (){
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy (linkText = "Fleet")
    //(xpath = "(//span[@class='title title-level-1'])[2]")
    public WebElement fleetTab;

    @FindBy (linkText = "Vehicles")
    public WebElement vehicles;

    @FindBy (xpath = "(//a[.='...'])[1]/..")
    //xpath = "(//div[@class=\'dropdown\'])[1]"
    ////a[.='...']
    public WebElement threeDots;

    @FindBy(xpath = "(//ul[@class='nav nav-pills icons-holder launchers-list'])[1]//li[1]")
    public WebElement viewIcon;

    @FindBy(xpath = "(//ul[@class='nav nav-pills icons-holder launchers-list'])[1]//li[2]")
    public WebElement editIcon;

    @FindBy(xpath = "(//ul[@class='nav nav-pills icons-holder launchers-list'])[1]//li[3]")
    public WebElement deleteIcon;


}
