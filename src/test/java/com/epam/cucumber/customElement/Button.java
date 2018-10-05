package com.epam.cucumber.customElement;

import org.openqa.selenium.WebElement;

public class Button extends Element {

    public Button(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void click() {
        waitBeforeAction(5000);
        super.click();
    }
}
