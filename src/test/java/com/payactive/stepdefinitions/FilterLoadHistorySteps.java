package com.payactive.stepdefinitions;

import com.payactive.common.DataCommon;
import com.payactive.constants.Constant;
import com.payactive.hooks.TestContext;
import com.payactive.pages.cards.FilterLoadHistoryPage;
import com.payactive.pages.cards.LoadHistoryPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilterLoadHistorySteps {
    LoadHistoryPage loadHistoryPage;
    FilterLoadHistoryPage filterLoadHistoryPage;

    public FilterLoadHistorySteps(TestContext testContext) {
        loadHistoryPage = testContext.getLoadHistoryPage();
        filterLoadHistoryPage = testContext.getFilterHistoryPage();
    }


    @When("User applies a filter to search for employee names in Load History")
    public void userAppliesFilterForEmployee() {
        applyFilter(() -> {
            filterLoadHistoryPage.clickEmployeeNameDropDown();
            filterLoadHistoryPage.setEmployeeNameInput(DataCommon.FILTER.LOAD_HISTORY_FILTER_DATA.get(Constant.EMPLOYEE_NAME_FILTER));
        });
    }


    @When("User applies a filter to search for employee id in Load History")
    public void userAppliesFilterForEmployeeId() {
        applyFilter(() -> {
            filterLoadHistoryPage.clickEmployeeIdDropDown();
            filterLoadHistoryPage.setEmployeeIdInput(DataCommon.FILTER.LOAD_HISTORY_FILTER_DATA.get(Constant.EMPLOYEE_ID_FILTER));
        });
    }

    @When("User applies a filter to search for department in Load History")
    public void userAppliesFilterForDepartment() {
        applyFilter(() -> {
            filterLoadHistoryPage.clickDepartmentDropDown();
            filterLoadHistoryPage.clickDepartmentMultiSelect();
            filterLoadHistoryPage.clickCheckboxDepartment();
        });
    }

    @When("User applies a filter to search for last 4 digits in Load History")
    public void userAppliesFilterForLast4Digits() {
        applyFilter(() -> {
            filterLoadHistoryPage.clickLast4DigitsOfCardDropDown();
            filterLoadHistoryPage.setLast4DigitsOfCardInput(DataCommon.FILTER.LOAD_HISTORY_FILTER_DATA.get(Constant.LAST_4_DIGITS_FILTER));
        });
    }

    private void applyFilter(Runnable filterActions) {
        loadHistoryPage.clickFilterInHistoryButton();
        filterLoadHistoryPage.clickResetButton();
        loadHistoryPage.waitForSpinnerLoading();
        loadHistoryPage.clickFilterInHistoryButton();
        filterActions.run();
        filterLoadHistoryPage.clickApplyButton();
        loadHistoryPage.waitForSpinnerLoading();
    }

    @Then("The list displays only the filtered Employees in Load History by {string}")
    public void theListDisplaysOnlyTheFilteredEmployees(String filterBy) {
        String filterByValue = switch (filterBy) {
            case Constant.EMPLOYEE_NAME_FILTER -> DataCommon.FILTER.LOAD_HISTORY_FILTER_DATA.get(Constant.EMPLOYEE_NAME_FILTER);
            case Constant.EMPLOYEE_ID_FILTER -> DataCommon.FILTER.LOAD_HISTORY_FILTER_DATA.get(Constant.EMPLOYEE_ID_FILTER);
            case Constant.DEPARTMENT_FILTER -> DataCommon.FILTER.LOAD_HISTORY_FILTER_DATA.get(Constant.DEPARTMENT_FILTER);
            case Constant.LAST_4_DIGITS_FILTER -> DataCommon.FILTER.LOAD_HISTORY_FILTER_DATA.get(Constant.LAST_4_DIGITS_FILTER);
            default -> "";
        };

        loadHistoryPage.verifyFilterData(filterBy, filterByValue);
    }

}
