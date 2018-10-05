package com.epam.cucumber.businessObjects;


import com.epam.cucumber.Pob.GmailEmailPage;
import com.epam.cucumber.Pob.GmailLoginPage;
import com.epam.cucumber.Pob.GmailPasswordPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class EmailBusinessObject {
    public GmailLoginPage gmailLoginPage;
    public GmailPasswordPage gmailPasswordPage;
    public GmailEmailPage gmailEmailPage;
    public WebDriver driver;

    public EmailBusinessObject(WebDriver driver) {
        //DriverConfiguration config = new DriverConfiguration();
        //  this.driver = config.configureDriver();
        this.driver = driver;
        this.gmailEmailPage = new GmailEmailPage(driver);
        this.gmailLoginPage = new GmailLoginPage(driver);
        this.gmailPasswordPage = new GmailPasswordPage(driver);
    }

    public void authorisationEmail(String login, String password) {
        gmailLoginPage.clickingingEmail();
        gmailLoginPage.enteringLogin(login);
        gmailLoginPage.clickingLoginNextBtn();
        gmailPasswordPage.enterPassword(password);
        gmailPasswordPage.clickingPasswordNextBtn();
    }

    public void writingLetterAndSubmit(String reciver, String subject, String text) {
        gmailEmailPage.clickingWriteBtn();
        gmailEmailPage.enteringEmail(reciver, subject, text);
        gmailEmailPage.clickingEmailSendBtn();
    }

    public void selectingSentLetter(String subject, String text) {
        gmailEmailPage.gettingSent();
        gmailEmailPage.enteringFirstLetter(driver);
        gmailEmailPage.verifyingSentLetter(subject, text);
        Assert.assertEquals(subject, gmailEmailPage.gettingSubject());
    }

    public void deletingSentLetter() {
        gmailEmailPage.deletingDeliveredMessage(driver);
    }

    public String getSubject() {
        return gmailEmailPage.gettingSubject();
    }

    public String getTextEmail() {
        return gmailEmailPage.gettingText();
    }
}
