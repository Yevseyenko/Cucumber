package com.epam.cucumber;


import com.epam.cucumber.businessObjects.EmailBusinessObject;
import com.epam.cucumber.pageParameters.PageParameters;
import org.junit.Assert;
import org.junit.Test;

public class GmailSendingTest {
  /*  private PageParameters pageParameters = new PageParameters();
    private String login = pageParameters.getPageParams("login");
    private String password = pageParameters.getPageParams("password");
    private String reciver = pageParameters.getPageParams("receiver");
    private String subject = pageParameters.getPageParams("subject");
    private String text = pageParameters.getPageParams("text");

    @Test
    public void sendingEmail() {

        EmailBusinessObject email = new EmailBusinessObject();
        email.authorisationEmail(login, password);
        email.writingLetterAndSubmit(reciver, subject, text);
        email.selectingSentLetter(subject, text);
        Assert.assertTrue(email.getSubject().equals(subject));
        Assert.assertTrue(email.getTextEmail().equals(text));
        email.deletingSentLetter();
    }
    */
}
