package com.payactive.stepdefinitions;

import com.payactive.driver.DriverManager;
import com.payactive.hooks.TestContext;
import com.payactive.keywords.WebUI;
import com.payactive.pages.CommonPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CommonSteps {

    TestContext testContext;
    CommonPage commonPage;

    public CommonSteps(TestContext testContext) {
        this.testContext = testContext;
        commonPage = testContext.getCommonPage();
    }

    @Given("user logged in as an admin")
    public void userLoggedInAsAnAdmin() {
    }

    @Given("user logged in the system with {string} role")
    public void userLoggedInTheSystemWithRole(String roleName) {
    }

    @Then("the message {string} displays")
    public void theMessageDisplays(String message) {
        Assert.assertEquals(commonPage.getMessageNotify(), message, "Message not match.");
    }

    @And("user should see the notification displays")
    public void userShouldSeeTheNotificationDisplays() {

    }

    @Then("User should see the page {string}")
    public void user_see_the_dashboard(String title) {
        WebUI.verifyEquals(DriverManager.getDriver().getTitle(), title);
    }
}
