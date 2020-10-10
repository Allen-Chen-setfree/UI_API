package com.automationpractice.unitTests;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/java/com/automationpractice/features",
        format = { "pretty","html:target/site/cucumber-pretty", "json:target/cucumber.json" },
        tags = {"@UnitTest"},
        glue = "com.automationpractice.stepdefs")



public class testRunner {


}
