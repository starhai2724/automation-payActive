package com.payactive.pages.cards;

import com.payactive.common.DataCommon;
import com.payactive.keywords.WebUI;
import com.payactive.pages.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static com.payactive.constants.Constant.CARD_HOLDER_FILTER_MAP;
import static com.payactive.constants.Constant.CARD_HOLDER_FILTER_MAP_COMPILE;
import static com.payactive.keywords.WebUI.*;

/**
 * Page Object Model for the Card Holder Page.
 */
public class CardHolderPage extends CommonPage {


    private final By downloadButton = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div[1]/div/div/div/div/nb-layout-column/ngx-components/ngx-cardholders/mat-drawer-container/mat-drawer-content/div/nb-card/nb-card-body/div[2]/button[2]");
    private final By employeeTable = By.cssSelector("#app-theme > nb-layout > div.scrollable-container > div > div > div > div > nb-layout-column > ngx-components > ngx-cardholders > mat-drawer-container > mat-drawer-content > div > nb-card > nb-card-body > div.table-container > ng2-smart-table");
    private final By downloadPopup = By.xpath("//*[@id=\"cdk-overlay-1\"]/nb-dialog-container/nb-card/div/h6");
    private final String employeeTableColumn = "//div[@class='table-container']//tbody/tr/td[%d]";
    private String headerColumnCommon = "//a[normalize-space()='%s']";
    private String headerColumnIndexCommon = "//div[@class='table-container']//tbody/tr/td[%d]";


    /**
     * Verifies that the employee table is visible on the page.
     */
    public void verifyEmployeeTableVisible() {
        verifyElementVisible(employeeTable);
    }

    /**
     * Verifies that the download popup is visible on the page.
     */
    public void downloadPopupVisible() {
        verifyElementVisible(downloadPopup);
    }

    public void verifyDownloadMessage(String message) {
        Assert.assertEquals(getElementText(downloadPopup), message, "Message not match.");
    }


    /**
     * Verifies that the data in the specified column contains the filter value.
     *
     * @param filterBy    The filter criteria (e.g., employee name, ID).
     * @param filterValue The value to filter by.
     */
    public void verifyFilterData(String filterBy, String filterValue) {
        By columnLocator = By.xpath(String.format(employeeTableColumn, CARD_HOLDER_FILTER_MAP.get(filterBy)));
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

    /**
     * Verifies that the data in the table matches the compiled filter data.
     */
    public void verifyCompileFilterData() {
        CARD_HOLDER_FILTER_MAP_COMPILE.forEach((filterBy, columnIndex) -> {
            By columnLocator = By.xpath(String.format(employeeTableColumn, columnIndex));
            List<String> uiValues = getWebElements(columnLocator).stream()
                    .map(WebElement::getText)
                    .map(String::toLowerCase)
                    .toList();

            uiValues.forEach(value -> {
                if (!value.contains(DataCommon.FILTER.CARD_HOLDER_FILTER_DATA.get(filterBy).toLowerCase())) {
                    Assert.fail("The value " + value + " does not contain the filter " + DataCommon.FILTER.CARD_HOLDER_FILTER_DATA.get(filterBy));
                }
            });
        });
    }

    /**
     * Clicks the download button.
     */
    public void clickDownloadButton() {
        clickElement(downloadButton);
    }

    /**
     * Clicks the header column for the first time to sort in ascending order.
     *
     * @param columnName The name of the column to sort.
     */
    public void clickHeaderColumnFirstTime(String columnName) {
        WebUI.waitForElementPresent(spinnerLoading);
        WebUI.waitForElementNotPresent(spinnerLoading);
        By headerColumnLocator = By.xpath(String.format(headerColumnCommon, columnName));
        WebUI.waitForElementClickable(headerColumnLocator);
        WebUI.clickElement(headerColumnLocator);
        WebUI.waitForElementPresent(spinnerLoading);
        WebUI.waitForElementNotPresent(spinnerLoading);
    }

    /**
     * Verifies that the specified column is sorted in ascending order.
     *
     * @param columnIndex The index of the column to verify.
     */
    public void verifySortedInAscendingOrderASCByEmployeeName(int columnIndex) {
        By columnLocator = By.xpath(String.format(headerColumnIndexCommon, columnIndex));
        WebUI.sortAndAssert(columnLocator, true);  // true for ascending order
    }

    /**
     * Clicks the header column for the second time to sort in descending order.
     *
     * @param columnName The name of the column to sort.
     */
    public void clickHeaderColumnSecondTime(String columnName) {
        WebUI.refreshPage();
        WebUI.waitForElementPresent(spinnerLoading);
        WebUI.waitForElementNotPresent(spinnerLoading);
        By headerColumnLocator = By.xpath(String.format("//a[normalize-space()='%s']", columnName));
        WebUI.waitForElementClickable(headerColumnLocator);
        WebUI.clickElement(headerColumnLocator);
        WebUI.waitForElementNotPresent(spinnerLoading);
        WebUI.clickElement(headerColumnLocator);
        WebUI.waitForElementNotPresent(spinnerLoading);
    }

    /**
     * Verifies that the specified column is sorted in descending order.
     *
     * @param columnIndex The index of the column to verify.
     */
    public void verifySortedInDescendingOrderDESCByEmployeeName(int columnIndex) {
        By columnLocator = By.xpath(String.format("//div[@class='table-container']//tbody/tr/td[%d]", columnIndex));
        WebUI.sortAndAssert(columnLocator, false);  // false for descending order
    }
}