package com.payactive.stepdefinitions;

import com.payactive.common.DataCommon;
import com.payactive.constants.Constant;
import com.payactive.hooks.TestContext;
import com.payactive.pages.cards.CardHolderPage;
import com.payactive.pages.cards.FilterCardHolderPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilterCardHolderSteps {

    FilterCardHolderPage filterCardHolderPage;
    CardHolderPage cardHolderPage;

    public FilterCardHolderSteps(TestContext testContext) {
        filterCardHolderPage = testContext.getFilterPage();
        cardHolderPage = testContext.getCardHolderPage();
    }

    @When("User applies a filter to search for employee names")
    public void userAppliesFilterForEmployee() {
        applyFilter(() -> {
            filterCardHolderPage.clickEmployeeNameDropdown();
            filterCardHolderPage.inputEmployeeName(DataCommon.FILTER.CARD_HOLDER_FILTER_DATA.get(Constant.EMPLOYEE_NAME_FILTER));
        });
    }

    @When("User applies a filter to search for employee id")
    public void userAppliesFilterForEmployeeId() {
        applyFilter(() -> {
            filterCardHolderPage.clickEmployeeIdDropdown();
            filterCardHolderPage.inputEmployeeId(DataCommon.FILTER.CARD_HOLDER_FILTER_DATA.get(Constant.EMPLOYEE_ID_FILTER));
        });
    }

    @When("User applies a filter to search for department")
    public void userAppliesFilterForDepartment() {
        applyFilter(() -> {
            filterCardHolderPage.clickDepartmentDropdown();
            filterCardHolderPage.clickDepartmentMultiSelect();
            filterCardHolderPage.clickDepartmentCheckbox();
        });
    }

    @When("User applies a filter to search for Card Status")
    public void userAppliesFilterForCardStatus() {
        applyFilter(() -> {
            filterCardHolderPage.clickCardStatusDropdown();
            filterCardHolderPage.clickCheckboxCardStatusSelectAll();
            filterCardHolderPage.clickCheckboxCardStatusActivated();
        });
    }

    @When("User applies a filter to search for Card Type")
    public void userAppliesFilterForCardType() {
        applyFilter(() -> {
            filterCardHolderPage.clickCardTypeDropdown();
            filterCardHolderPage.clickCheckboxCardTypeSelectAll();
            filterCardHolderPage.clickCheckboxCarTypeInstantIssue();
        });
    }

    @When("User applies a compile filter to search for employees")
    public void userAppliesCompileFilterForEmployees() {
        applyFilter(() -> {
            filterCardHolderPage.clickEmployeeNameDropdown();
            filterCardHolderPage.inputEmployeeName(DataCommon.FILTER.CARD_HOLDER_FILTER_DATA.get(Constant.EMPLOYEE_NAME_FILTER));
            filterCardHolderPage.clickEmployeeIdDropdown();
            filterCardHolderPage.inputEmployeeId(DataCommon.FILTER.CARD_HOLDER_FILTER_DATA.get(Constant.EMPLOYEE_ID_FILTER));
            filterCardHolderPage.clickCardStatusDropdown();
            filterCardHolderPage.clickCheckboxCardStatusSelectAll();
            filterCardHolderPage.clickCheckboxCardStatusActivated();
            filterCardHolderPage.clickCardTypeDropdown();
            filterCardHolderPage.clickCheckboxCardTypeSelectAll();
            filterCardHolderPage.clickCheckboxCarTypeInstantIssue();
        });
    }

    @When("User filters cardholder with Instant Issue Card Type and Not Activated Card Status")
    public void userFiltersCardholderWithInstantIssueCardTypeAndNotActivatedCardStatus() {
        applyFilter(() -> {
            filterCardHolderPage.clickCardTypeDropdown();
            filterCardHolderPage.clickCheckboxCardTypeSelectAll();
            filterCardHolderPage.clickCheckboxCarTypeInstantIssue();
            filterCardHolderPage.clickCardStatusDropdown();
            filterCardHolderPage.clickCheckboxCardStatusSelectAll();
            filterCardHolderPage.clickCheckboxCardStatusNotActivated();
        });
    }

    @When("User filters cardholder with Instant Issue Card Type and Blocked Card Status")
    public void userFiltersCardholderWithInstantIssueCardTypeAndBlockedCardStatus() {
        applyFilter(() -> {
            filterCardHolderPage.clickCardTypeDropdown();
            filterCardHolderPage.clickCheckboxCardTypeSelectAll();
            filterCardHolderPage.clickCheckboxCarTypeInstantIssue();
            filterCardHolderPage.clickCardStatusDropdown();
            filterCardHolderPage.clickCheckboxCardStatusSelectAll();
            filterCardHolderPage.clickCheckboxCardStatusBlocked();
        });
    }

    @When("User filters cardholder with Instant Issue Card Type and Fraud Blocked Card Status")
    public void userFiltersCardholderWithInstantIssueCardTypeAndFraudBlockedCardStatus() {
        applyFilter(() -> {
            filterCardHolderPage.clickCardTypeDropdown();
            filterCardHolderPage.clickCheckboxCardTypeSelectAll();
            filterCardHolderPage.clickCheckboxCarTypeInstantIssue();
            filterCardHolderPage.clickCardStatusDropdown();
            filterCardHolderPage.clickCheckboxCardStatusSelectAll();
            filterCardHolderPage.clickCheckboxCardStatusFraudBlocked();
        });
    }

    @When("User filters cardholder with Instant Issue Card Type and Pending Consent Card Status")
    public void userFiltersCardholderWithInstantIssueCardTypeAndPendingConsentCardStatus() {
        applyFilter(() -> {
            filterCardHolderPage.clickCardTypeDropdown();
            filterCardHolderPage.clickCheckboxCardTypeSelectAll();
            filterCardHolderPage.clickCheckboxCarTypeInstantIssue();
            filterCardHolderPage.clickCardStatusDropdown();
            filterCardHolderPage.clickCheckboxCardStatusSelectAll();
            filterCardHolderPage.clickCheckboxCardStatusPendingConsent();
        });
    }

    private void applyFilter(Runnable filterActions) {
        filterCardHolderPage.clickFilter();
        filterCardHolderPage.clickResetBtn();
        filterCardHolderPage.waitForSpinnerLoading();
        filterCardHolderPage.clickFilter();
        filterActions.run();
        filterCardHolderPage.clickApplyBtn();
        filterCardHolderPage.waitForSpinnerLoading();
    }

    @Then("The list displays only the filtered Employees by {string}")
    public void theListDisplaysOnlyTheFilteredEmployees(String filterBy) {
        String filterByValue = switch (filterBy) {
            case Constant.EMPLOYEE_NAME_FILTER -> DataCommon.FILTER.CARD_HOLDER_FILTER_DATA.get(Constant.EMPLOYEE_NAME_FILTER);
            case Constant.EMPLOYEE_ID_FILTER -> DataCommon.FILTER.CARD_HOLDER_FILTER_DATA.get(Constant.EMPLOYEE_ID_FILTER);
            case Constant.DEPARTMENT_FILTER -> DataCommon.FILTER.CARD_HOLDER_FILTER_DATA.get(Constant.DEPARTMENT_FILTER);
            case Constant.CARD_STATUS_FILTER -> DataCommon.FILTER.CARD_HOLDER_FILTER_DATA.get(Constant.CARD_STATUS_FILTER);
            case Constant.CARD_TYPE_FILTER -> DataCommon.FILTER.CARD_HOLDER_FILTER_DATA.get(Constant.CARD_TYPE_FILTER);
            default -> "";
        };

        cardHolderPage.verifyFilterData(filterBy, filterByValue);
    }

    @Then("The list only displays employees that have been compiled")
    public void theListOnlyDisplaysEmployeesThatHaveBeenCompiled() {
        cardHolderPage.verifyCompileFilterData();
    }


    @When("User clicks Reset button")
    public void userClicksResetButton() {
        filterCardHolderPage.clickFilter();
        filterCardHolderPage.clickResetBtn();
        filterCardHolderPage.waitForSpinnerLoading();
    }

    @Then("The list displays the list of all cardholders")
    public void theListDisplaysAllCardholders() {
        cardHolderPage.verifyEmployeeTableVisible();
    }

}
