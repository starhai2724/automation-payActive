package com.payactive.pages.cards;

import com.payactive.common.DataCommon;
import com.payactive.keywords.WebUI;
import com.payactive.pages.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static com.payactive.constants.Constant.FILTER_MAP;
import static com.payactive.constants.Constant.FILTER_MAP_COMPILE;
import static com.payactive.keywords.WebUI.*;

public class CardHolderPage extends CommonPage {

    private final By cardDropdown = By.xpath("//*[@id=\"sidebar-hide\"]/div/div/nb-menu/ul/li[6]/a");
    private final By cardHolder = By.xpath("//*[@id=\"sidebar-hide\"]/div/div/nb-menu/ul/li[6]/ul/li[1]/a");

    private final By employeeTable = By.cssSelector("#app-theme > nb-layout > div.scrollable-container > div > div > div > div > nb-layout-column > ngx-components > ngx-cardholders > mat-drawer-container > mat-drawer-content > div > nb-card > nb-card-body > div.table-container > ng2-smart-table");

    private final String employeeTableColumn = "//div[@class='table-container']//tbody/tr/td[%d]";

    private String headerColumnCommon = "//a[normalize-space()='%s']";
    private String headerColumnIndexCommon = "//div[@class='table-container']//tbody/tr/td[%d]";

    public void clickCardDropdown() {
        clickElement(cardDropdown);
    }

    public void clickCardHolder() {
        clickElement(cardHolder);
    }

    public void verifyEmployeeTableVisible() {
        verifyElementVisible(employeeTable);
    }

    public void verifyFilterData(String filterBy, String filterValue) {
        By columnLocator = By.xpath(String.format(employeeTableColumn, FILTER_MAP.get(filterBy)));
        List<String> uiValues = getWebElements(columnLocator).stream()
                .map(WebElement::getText)
                .map(String::toLowerCase)
                .toList();

        uiValues.forEach(value -> {
            if (!value.contains(filterValue.toLowerCase())) {
                Assert.fail("The value " + value + " does not contain the filter " + filterValue);
            }
        });
    }

    public void verifyCompileFilterData() {
        FILTER_MAP_COMPILE.forEach((filterBy, columnIndex) -> {
            By columnLocator = By.xpath(String.format(employeeTableColumn, columnIndex));
            List<String> uiValues = getWebElements(columnLocator).stream()
                    .map(WebElement::getText)
                    .map(String::toLowerCase)
                    .toList();

            uiValues.forEach(value -> {
                if (!value.contains(DataCommon.FILTER.FILTER_DATA.get(filterBy).toLowerCase())) {
                    Assert.fail("The value " + value + " does not contain the filter " + DataCommon.FILTER.FILTER_DATA.get(filterBy));
                }
            });
        });
    }


    public void clickHeaderColumnFirstTime(String columnName) {

        WebUI.waitForElementPresent(spinnerLoading);
        WebUI.waitForElementNotPresent(spinnerLoading);
        By headerColumnLocator = By.xpath(String.format(headerColumnCommon, columnName));
        WebUI.waitForElementClickable(headerColumnLocator);
        WebUI.clickElement(headerColumnLocator);
        WebUI.waitForElementPresent(spinnerLoading);
        WebUI.waitForElementNotPresent(spinnerLoading);
    }

    public void verifySortedInAscendingOrderASCByEmployeeName(int columnIndex) {
        // Create an XPath to find all the cells in the specified column
        By columnLocator = By.xpath(String.format(headerColumnIndexCommon, columnIndex));

        // Call the sortAndAssert method to verify if the column is sorted in ascending order
        WebUI.sortAndAssert(columnLocator, true);  // true for ascending order
    }


    public void clickHeaderColumnSecondTime(String columnName) {
        WebUI.refreshPage();
        WebUI.waitForElementPresent(spinnerLoading);
        WebUI.waitForElementNotPresent(spinnerLoading);
        By headerColumnLocator = By.xpath(String.format("//a[normalize-space()='%s']", columnName));
        WebUI.waitForElementClickable(headerColumnLocator);
        WebUI.clickElement(headerColumnLocator);
//        WebUI.waitForElementPresent(spinnerLoading);
        WebUI.waitForElementNotPresent(spinnerLoading);
        WebUI.clickElement(headerColumnLocator);
//        WebUI.waitForElementPresent(spinnerLoading);
        WebUI.waitForElementNotPresent(spinnerLoading);
    }
    public void verifySortedInDescendingOrderDESCByEmployeeName(int columnIndex) {
        // Create an XPath to find all the cells in the specified column
        By columnLocator = By.xpath(String.format("//div[@class='table-container']//tbody/tr/td[%d]", columnIndex));

        // Call the sortAndAssert method to verify if the column is sorted in ascending order
        WebUI.sortAndAssert(columnLocator, false);  // true for ascending order
    }

}
