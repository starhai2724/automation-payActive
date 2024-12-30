package com.payactive.stepdefinitions;

import com.payactive.hooks.TestContext;
import com.payactive.pages.cards.CardHamburgerMenuPage;
import com.payactive.pages.cards.CardHolderActionPage;
import com.payactive.pages.cards.CardHolderPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CardHolderSteps {

    CardHolderPage cardHolderPage;
    CardHamburgerMenuPage cardHamburgerMenuPage;
    CardHolderActionPage cardHolderActionPage;

    public CardHolderSteps(TestContext testContext) {
        cardHolderPage = testContext.getCardHolderPage();
        cardHamburgerMenuPage = testContext.getCardHamburgerMenuPage();
        cardHolderActionPage = testContext.getCardHolderActionPage();
    }

    @And("User click on the card dropdown menu")
    public void i_click_on_the_card_dropdown_link() {
        cardHolderPage.clickCardDropdown();
    }

    @And("User click on the Card Holder link")
    public void i_click_on_the_card_holder_link() {
        cardHamburgerMenuPage.clickCardHolder();
    }

    @And("User click on the Load History link")
    public void i_click_on_the_load_history_link() {
        cardHamburgerMenuPage.clickLoadHistory();
    }

    @And("User clicks Cards menu and then select Load History submenu")
    public void user_click_card_menu_and_select_load_history() {
        cardHolderPage.clickCardDropdown();
        cardHamburgerMenuPage.clickLoadHistory();
    }

    @And("User clicks Cards menu and then select Cardholders submenu")
    public void user_click_card_menu_and_select_card() {
        cardHolderPage.clickCardDropdown();
        cardHamburgerMenuPage.clickCardHolder();
    }

    @Then("User can view the list of all cardholders")
    public void user_can_view_the_list_of_all_cardholders() {
        cardHolderPage.verifyEmployeeTableVisible();
        cardHolderPage.waitForSpinnerLoading();
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

    @When("User clicks on Download Direct Deposit Information link")
    public void userClicksOnDownloadDirectDepositInformationLink() {
        cardHolderPage.clickDownloadButton();
    }

    @Then("The Download popup is displayed with the message {string}")
    public void thePopupDownloadDirectDepositInformationIsDisplayed(String message) {
        cardHolderPage.downloadPopupVisible();
        cardHolderPage.verifyDownloadMessage(message);
    }

    @And("User clicks on Account Info option")
    public void userClicksOnAccountInfoOption() {
        cardHolderActionPage.clickActionButton();
        cardHolderActionPage.clickAccountInfoOption();
    }

}
