package com.epam.cucumber;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources",
            glue = {"com.epam.cucumber.steps"},
            format = {"pretty", "html:target/cucumber"})
public class GmailSendTest {
}
