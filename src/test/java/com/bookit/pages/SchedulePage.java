package com.bookit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SchedulePage extends com.bookit.pages.basePage {

    @FindBy(xpath = "//td[@class='conference']")
    public WebElement coloredBoxSolid;

    @FindBy(xpath = "//td[@class='conference iffy']")
    public WebElement coloredBoxIffy;

    @FindBy(css = "button[class='button is-danger']")
    public WebElement cancelConfBtn;

}
