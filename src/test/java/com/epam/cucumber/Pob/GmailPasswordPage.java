package com.epam.cucumber.Pob;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailPasswordPage {
    private static final Logger log =LogManager.getLogger("log4j2");
    @FindBy(css = "input[name=\"password\"]")
    private WebElement passwordInput;
    @FindBy(id = "passwordNext")
    private WebElement passwordNextBtn;

    @FindBy(xpath = "//div[@id='password']/div/div[@aria-live='assertive']")
    private WebElement errorMessage;

    public GmailPasswordPage(WebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    public void enterPassword(String password) {
        log.info("Inputting password"+ password);
        passwordInput.sendKeys(password);
     try {
         Thread.sleep(4000);
     }catch (InterruptedException e){
         log.info(e.getMessage());}
    }

    public void clickingPasswordNextBtn() {
        log.info("Clicking Next Button");
        passwordNextBtn.click();
    }
    public boolean getErrorMessageDisplayed(){
        log.info("Wrong password");
           errorMessage.isDisplayed();
            return true;
    }

    private void waitForClickable(WebElement element, WebDriver driver) {
        new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(element));
    }
}
