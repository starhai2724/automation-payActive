package com.payactive.stepdefinitions;

import com.payactive.common.BaseTest;
import com.payactive.common.DataCommon;
import com.payactive.constants.ConstantGlobal;
import com.payactive.driver.DriverManager;
import com.payactive.hooks.TestContext;
import com.payactive.keywords.WebUI;
import com.payactive.models.Credentials;
import com.payactive.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    LoginPage loginPage;

    public LoginSteps(TestContext testContext) {
        loginPage = testContext.getLoginPage();
    }

    @Given("User navigate to Login page")
    public void userNavigateToLoginPage() {
        BaseTest.createDriver();
        WebUI.openURL(ConstantGlobal.URL);
    }

    @When("User enter valid email and password")
    public void userEnterEmailAndPassword() {
        Credentials credentials = DataCommon.credentialsList.getFirst();
        loginPage.enterEmailAndPassword(credentials.getUsername(), credentials.getPassword());
    }

    @And("User click login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("User should see the dashboard page {string}")
    public void user_see_the_dashboard(String title) {
        WebUI.verifyEquals(DriverManager.getDriver().getTitle(), title);
    }
}
