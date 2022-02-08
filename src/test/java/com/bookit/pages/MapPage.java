package com.bookit.pages;

import com.bookit.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MapPage extends basePage{

    @FindBy(tagName = "h1")
    public WebElement heading;

    @FindBy(linkText = "hunt")
    public WebElement huntBtn;

    @FindBy(linkText = "schedule")
    public WebElement scheduleBtn;
    public void selectScheduleOption(String str){
        WebElement element = Driver.getDriver().findElement(By.xpath("//div[@class='navbar-dropdown is-transparent']//a[.='" + str + "']"));
        element.click();
    }

}
