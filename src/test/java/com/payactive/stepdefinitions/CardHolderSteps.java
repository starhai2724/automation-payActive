package com.payactive.stepdefinitions;

import com.payactive.hooks.TestContext;
import com.payactive.pages.cards.CardHolderPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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

    @And("User clicks Cards menu and then select Cardholders submenu")
    public void user_click_card_menu_and_select_card() {
        cardHolderPage.clickCardDropdown();
        cardHolderPage.clickCardHolder();
    }

    @Then("User can view the list of all cardholders")
    public void user_can_view_the_list_of_all_cardholders() {
        cardHolderPage.verifyEmployeeTableVisible();
    }


    @When("User clicks Employee header for the first time")
    public void userClicksEmployeeHeaderForTheFirstTime() {
        cardHolderPage.clickHeaderColumnFirstTime("Employee");
    }

    @Then("The list is sorted in ascending order \\(ASC) by Employee Name")
    public void theListIsSortedInAscendingOrderASCByEmployeeName() {
        cardHolderPage.verifySortedInAscendingOrderASCByEmployeeName(1);

    }

    @When("User clicks Employee header for the second time")
    public void userClicksEmployeeHeaderForTheSecondTime() {
        cardHolderPage.clickHeaderColumnSecondTime("Employee");

    }

    @Then("The list is sorted in descending order \\(DESC) by Employee Name")
    public void theListIsSortedInDescendingOrderDESCByEmployeeName() {
        cardHolderPage.verifySortedInDescendingOrderDESCByEmployeeName(1);

    }

}
