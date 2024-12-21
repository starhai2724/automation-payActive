package com.payactive.stepdefinitions;

import com.payactive.hooks.TestContext;
import com.payactive.pages.cards.CardHolderPage;
import io.cucumber.java.en.And;

public class CardHolderSteps {

    CardHolderPage cardHolderPage;

    public CardHolderSteps(TestContext testContext) {
        cardHolderPage = testContext.getCardHolderPage();
    }

    @And("User click on the card dropdown menu")
    public void i_click_on_the_card_dropdown_link() {
        cardHolderPage.clickCardDropdown();
    }

    @And("User click on the card holder link")
    public void i_click_on_the_card_holder_link() {
        cardHolderPage.clickCardHolder();
    }

}
