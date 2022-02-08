package com.bookit.stepDefinitions;

import com.bookit.pages.LoginPage;
import com.bookit.pages.MapPage;
import com.bookit.utility.BrowserUtil;
import com.bookit.utility.ConfigurationReader;
import com.bookit.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class loginStepDefinitions {

        LoginPage loginPage = new LoginPage();
        MapPage mapPage = new MapPage();


    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
            Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        }
    @When("User enters email {string} and password {string}")
    public void userEntersEmailAndPassword(String email, String password) {
            loginPage.login(email,password);

        }
        @Then("Home Page should be displayed with {string} heading")
                public void home_page_should_be_displayed_with_heading(String expectedHeading){
            BrowserUtil.sleep(5);
            BrowserUtil.verifyElementDisplayed(mapPage.heading);
            Assert.assertEquals(expectedHeading,mapPage.heading.getText());

        }



}

