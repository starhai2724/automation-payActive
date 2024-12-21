package com.payactive.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features/pay-active/card-holders",
        glue = {"com.payactive.stepdefinitions",
                "com.payactive.common",
                "com.payactive.hooks"
        },
        plugin = {
                "com.payactive.hooks.CucumberListener",
                "pretty",
                "html:target/cucumber-reports/cardHolder.html",
                "json:target/cucumber-reports/cardHolder.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)
@Test
public class TestRunnerCardHolder extends AbstractTestNGCucumberTests {
    //Parallel Execution Scenario
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}