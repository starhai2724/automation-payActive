package com.payactive.stepdefinitions;

import com.payactive.common.DataCommon;
import com.payactive.constants.Constant;
import com.payactive.hooks.TestContext;
import com.payactive.pages.cards.CardHolderPage;
import com.payactive.pages.cards.FilterPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilterSteps {

    FilterPage filterPage;
    CardHolderPage cardHolderPage;

    public FilterSteps(TestContext testContext) {
        filterPage = testContext.getFilterPage();
        cardHolderPage = testContext.getCardHolderPage();
    }

    @When("User applies a filter to search for employee names")
    public void userAppliesFilterForEmployee() {
        filterPage.waitForSpinnerLoading();
        applyFilter(() -> {
            filterPage.clickEmployeeNameDropdown();
            filterPage.inputEmployeeName(DataCommon.FILTER.FILTER_DATA.get(Constant.EMPLOYEE_NAME_FILTER));
        });
    }

    @When("User applies a filter to search for employee id")
    public void userAppliesFilterForEmployeeId() {
        applyFilter(() -> {
            filterPage.clickEmployeeIdDropdown();
            filterPage.inputEmployeeId(DataCommon.FILTER.FILTER_DATA.get(Constant.EMPLOYEE_ID_FILTER));
        });
    }

    @When("User applies a filter to search for department")
    public void userAppliesFilterForDepartment() {
        applyFilter(() -> {
            filterPage.clickDepartmentDropdown();
            filterPage.clickDepartmentMultiSelect();
            filterPage.clickDepartmentCheckbox();
        });
    }

    @When("User applies a filter to search for Card Status")
    public void userAppliesFilterForCardStatus() {
        applyFilter(() -> {
            filterPage.clickCardStatusDropdown();
            filterPage.clickCheckboxCardStatusSelectAll();
            filterPage.clickCheckboxCardStatusActivated();
        });
    }

    @When("User applies a filter to search for Card Type")
    public void userAppliesFilterForCardType() {
        applyFilter(() -> {
            filterPage.clickCardTypeDropdown();
            filterPage.clickCheckboxCardTypeSelectAll();
            filterPage.clickCheckboxCarTypeInstantIssue();
        });
    }

    @When("User applies a compile filter to search for employees")
    public void userAppliesCompileFilterForEmployees() {
        filterPage.waitForSpinnerLoading();
        applyFilter(() -> {
            filterPage.clickEmployeeNameDropdown();
            filterPage.inputEmployeeName(DataCommon.FILTER.FILTER_DATA.get(Constant.EMPLOYEE_NAME_FILTER));
            filterPage.clickEmployeeIdDropdown();
            filterPage.inputEmployeeId(DataCommon.FILTER.FILTER_DATA.get(Constant.EMPLOYEE_ID_FILTER));
//            filterPage.clickDepartmentDropdown();
//            filterPage.clickDepartmentMultiSelect();
//            filterPage.clickDepartmentCheckbox();
            filterPage.clickCardStatusDropdown();
            filterPage.clickCheckboxCardStatusSelectAll();
            filterPage.clickCheckboxCardStatusActivated();
            filterPage.clickCardTypeDropdown();
            filterPage.clickCheckboxCardTypeSelectAll();
            filterPage.clickCheckboxCarTypeInstantIssue();
        });
    }

    private void applyFilter(Runnable filterActions) {
        filterPage.clickFilter();
        filterPage.clickResetBtn();
        filterPage.waitForSpinnerLoading();
        filterPage.clickFilter();
        filterActions.run();
        filterPage.clickApplyBtn();
        filterPage.waitForSpinnerLoading();
    }

    @Then("The list displays only the filtered Employees by {string}")
    public void theListDisplaysOnlyTheFilteredEmployees(String filterBy) {
        String filterByValue = switch (filterBy) {
            case Constant.EMPLOYEE_NAME_FILTER -> DataCommon.FILTER.FILTER_DATA.get(Constant.EMPLOYEE_NAME_FILTER);
            case Constant.EMPLOYEE_ID_FILTER -> DataCommon.FILTER.FILTER_DATA.get(Constant.EMPLOYEE_ID_FILTER);
            case Constant.DEPARTMENT_FILTER -> DataCommon.FILTER.FILTER_DATA.get(Constant.DEPARTMENT_FILTER);
            case Constant.CARD_STATUS_FILTER -> DataCommon.FILTER.FILTER_DATA.get(Constant.CARD_STATUS_FILTER);
            case Constant.CARD_TYPE_FILTER -> DataCommon.FILTER.FILTER_DATA.get(Constant.CARD_TYPE_FILTER);
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
        filterPage.clickFilter();
        filterPage.clickResetBtn();
        filterPage.waitForSpinnerLoading();
    }

    @Then("The list displays the list of all cardholders")
    public void theListDisplaysAllCardholders() {
        cardHolderPage.verifyEmployeeTableVisible();
    }

}
