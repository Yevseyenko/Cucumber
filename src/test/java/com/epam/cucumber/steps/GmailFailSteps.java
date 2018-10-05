package com.epam.cucumber.steps;

import com.epam.cucumber.businessObjects.EmailBusinessObject;
import com.epam.cucumber.driverConfig.DriverConfiguration;
import com.epam.cucumber.driverConfig.DriverParameters;
import com.epam.cucumber.pageParameters.PageParameters;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GmailFailSteps {
    WebDriver driver;
    DriverConfiguration conf;
    EmailBusinessObject email;
    DriverParameters parameters;
    private PageParameters pageParameters = new PageParameters();
    private String reciver = pageParameters.getPageParams("receiver");
    private String subject = pageParameters.getPageParams("subject");
    private String text = pageParameters.getPageParams("text");

    @Before
    public void driverConfig1() throws IOException {
        parameters = new DriverParameters();
        System.setProperty(parameters.getProp("webdriver"),
                parameters.getProp("driverpath"));
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(
                Integer.parseInt(parameters.getProp("delay")), TimeUnit.SECONDS);
    }

    @Given("^user navigates to Google once more$")
    public void navigateFailGmail() {
        driver.get("http://www.google.com.ua");

    }

    @When("^I enter Login as (.*) and wrong password as (.*)$")
    public void i_enter_wrong_Login_and_password(String login, String password) {
        email = new EmailBusinessObject(driver);
        email.authorisationEmail(login, password);
    }

    @Then("^The login should be unsuccesfull$")
    public void loginUnsuccessful() {
        Assert.assertTrue(email.gmailPasswordPage.getErrorMessageDisplayed());
    }


    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}

