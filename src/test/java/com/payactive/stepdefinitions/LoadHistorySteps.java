package com.payactive.stepdefinitions;

import com.payactive.hooks.TestContext;
import com.payactive.pages.cards.FilterLoadHistoryPage;
import com.payactive.pages.cards.LoadHistoryPage;
import io.cucumber.java.en.Then;

public class LoadHistorySteps {
    LoadHistoryPage loadHistoryPage;
    FilterLoadHistoryPage filterLoadHistoryPage;

    public LoadHistorySteps(TestContext testContext) {
        loadHistoryPage = testContext.getLoadHistoryPage();
        filterLoadHistoryPage = testContext.getFilterHistoryPage();
    }

    @Then("User can view the list of Load History")
    public void user_can_view_the_list_of_load_history() {
        loadHistoryPage.verifyEmployeeTableVisible();
        loadHistoryPage.waitForSpinnerLoading();
    }
}
