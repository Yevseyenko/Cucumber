package com.epam.cucumber.customElement;

import org.openqa.selenium.WebElement;

public class Label extends Element {
    public Label(WebElement webElement) {
        super(webElement);
    }

    @Override
    public String getText() {
        return super.webElement.getText();
    }

}