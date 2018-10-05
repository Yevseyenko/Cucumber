package com.epam.cucumber.steps;


import com.epam.cucumber.businessObjects.EmailBusinessObject;
import com.epam.cucumber.driverConfig.DriverConfiguration;
import com.epam.cucumber.driverConfig.DriverParameters;
import com.epam.cucumber.pageParameters.PageParameters;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GmailSteps {
    WebDriver driver;
    DriverConfiguration conf;
    EmailBusinessObject email;
    DriverParameters parameters;
    private PageParameters pageParameters = new PageParameters();
    private String reciver = pageParameters.getPageParams("receiver");
    private String subject = pageParameters.getPageParams("subject");
    private String text = pageParameters.getPageParams("text");

    @Before
    public void driverConfig() throws IOException {
        parameters = new DriverParameters();
        System.setProperty(parameters.getProp("webdriver"),
                parameters.getProp("driverpath"));
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(
                Integer.parseInt(parameters.getProp("delay")), TimeUnit.SECONDS);
    }

    @Given("^user navigates to Google$")
    public void navigateGmail() {
        driver.get("http://www.google.com.ua");

    }

    @When("^I enter Login as (.*) and password as (.*)$")
    public void i_enter_Login_and_password(String login, String password) {
        email = new EmailBusinessObject(driver);
        email.authorisationEmail(login, password);
    }

    @Then("^The login should be succesfull$")
    public void loginSuccessful() {
        email.gmailEmailPage.clickingMailBtn();
    }

    @Then("^Send letter and delete it$")
    public void sendLetter_and_Delete() {
        email.writingLetterAndSubmit(reciver,subject,text);
        email.selectingSentLetter(subject,text);
        email.deletingSentLetter();
    }
    @After
    public void quit(){
        driver.close();
        driver.quit();
    }
}
