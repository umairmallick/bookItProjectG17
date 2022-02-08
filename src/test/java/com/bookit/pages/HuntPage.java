package com.bookit.pages;

import com.bookit.utility.BrowserUtil;
import com.bookit.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HuntPage extends com.bookit.pages.basePage {

    @FindBy(tagName = "h1")
    public WebElement huntHeading;

    @FindBy(xpath = "//div[@class='mat-form-field-flex']")
    private WebElement typeDateBox;

    @FindBy(xpath = "//div[@class='mat-form-field-flex']//input")
    public WebElement typeDate;

    @FindBy(xpath = "//span[@class='mat-select-placeholder ng-tns-c20-2 ng-star-inserted']")
    private WebElement timeFrom;

    @FindBy(xpath = "//span[@class='mat-select-placeholder ng-tns-c20-4 ng-star-inserted']")
    private WebElement timeTo;

    @FindBy(xpath = "//button[@class='mat-button']")
    public WebElement submitBtn;

    @FindBy(tagName = "h2")
    public WebElement reviewTime;

    @FindBy(css = "p[class='title is-size-4']")
    public List<WebElement> availableRoom;

    @FindBy(xpath ="//button[@class='button is-transparent is-white']" )
    private WebElement selectRoom;


    @FindBy(xpath = "//app-room-info/..//p[@class='title is-size-4']")
    public WebElement selectedRoomNameonConfirmationPage;

    @FindBy(className = "level-item")
    public WebElement confirmBtn;

    @FindBy(xpath = "//h1[@class='title has-text-grey-dark']")
    public WebElement confirmationHeader;

    @FindBy(xpath = "//div[@class='cdk-overlay-container']//div[@class='cdk-overlay-pane']//span")
    private WebElement errorMsg;
    public boolean checkErrorMsg(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(errorMsg));
        if(errorMsg.isDisplayed()) return true;
        return false;
    }

    public void setSchedule(String date, String from, String to){

        try {
            typeDateBox.click();
            typeDate.sendKeys(date);
        }catch (ElementNotInteractableException e){
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].value='"+date+"'",typeDate);
        }

        timeFrom.click();
        BrowserUtil.sleep(1);
        List<WebElement> fromSelect = Driver.getDriver().findElements(By.xpath("//span[@class='mat-option-text']"));
        fromSelect.forEach(each->{
            if(each.getText().equalsIgnoreCase(from)) {
                each.click();
            }
        });

        timeTo.click();
        BrowserUtil.sleep(1);
        List<WebElement> toSelect = Driver.getDriver().findElements(By.xpath("//span[@class='mat-option-text']"));
        toSelect.forEach(each->{

            if(each.getText().equalsIgnoreCase(to)) each.click();
        });

    }

    public void setSelectRoom(String room){
        BrowserUtil.sleep(1);
       List<WebElement> lol= Driver.getDriver().findElements(By.xpath("//button[@class='button is-transparent is-white']/../../preceding-sibling::div/p"));
       lol.forEach(each-> {
           if(each.getText().contains(room))
               selectRoom.click();
       });

    }

}
