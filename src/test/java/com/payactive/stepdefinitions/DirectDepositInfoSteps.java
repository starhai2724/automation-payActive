package com.payactive.stepdefinitions;

import com.payactive.hooks.TestContext;
import com.payactive.pages.cards.DirectDepositInfoPage;
import io.cucumber.java.en.Then;

public class DirectDepositInfoSteps {

    DirectDepositInfoPage directDepositInfoPage;

    public DirectDepositInfoSteps(TestContext testContext) {
        directDepositInfoPage = testContext.getDirectDepositInfoPage();
    }

    @Then("The Direct Deposit Info Popup displays")
    public void theDirectDepositInfoPopupDisplays() {
        directDepositInfoPage.verifyDepositPopupVisible();
        directDepositInfoPage.verifyBankNameText();
        directDepositInfoPage.verifyRoutingText();
        directDepositInfoPage.verifyAccountText();
    }

}
