package com.bookit.pages;

import com.bookit.utility.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class basePage {

    public basePage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }

}
