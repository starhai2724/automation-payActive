package com.payactive.pages.cards;

import com.payactive.common.DataCommon;
import com.payactive.constants.Constant;
import com.payactive.pages.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static com.payactive.constants.Constant.CARD_HOLDER_FILTER_MAP;
import static com.payactive.constants.Constant.LOAD_HISTORY_FILTER_MAP;
import static com.payactive.keywords.WebUI.*;

public class LoadHistoryPage extends CommonPage {

    private final By loadHistoryTable = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div/div/div/div/div/nb-layout-column/ngx-components/ngx-card-load-history/mat-drawer-container/mat-drawer-content/div/nb-card/nb-card-body/div[3]");

    private final By filterInHistoryButton = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div/div/div/div/div/nb-layout-column/ngx-components/ngx-card-load-history/mat-drawer-container/mat-drawer-content/div/nb-card/nb-card-body/div[1]");

    private final String loadHistoryTableColumn = "//div[@class='table-container']//tbody/tr/td[%d]";

    public void verifyEmployeeTableVisible() {
        waitForElementVisible(loadHistoryTable);
    }

    public void clickFilterInHistoryButton() {
        clickElement(filterInHistoryButton);
    }


    /**
     * Verifies that the data in the table matches the compiled filter data.
     */
    public void verifyCompileFilterData() {
        LOAD_HISTORY_FILTER_MAP.forEach((filterBy, columnIndex) -> {
            By columnLocator = By.xpath(String.format(loadHistoryTableColumn, columnIndex));
            List<String> uiValues = getWebElements(columnLocator).stream()
                    .map(WebElement::getText)
                    .map(String::toLowerCase)
                    .toList();

            uiValues.forEach(value -> {
                if (!value.contains(DataCommon.FILTER.LOAD_HISTORY_FILTER_DATA.get(filterBy).toLowerCase())) {
                    Assert.fail("The value " + value + " does not contain the filter " + DataCommon.FILTER.LOAD_HISTORY_FILTER_DATA.get(filterBy));
                }
            });
        });
    }



    /**
     * Verifies that the data in the specified column contains the filter value.
     *
     * @param filterBy    The filter criteria (e.g., employee name, ID).
     * @param filterValue The value to filter by.
     */
    public void verifyFilterData(String filterBy, String filterValue) {
        By columnLocator = By.xpath(String.format(loadHistoryTableColumn, Constant.LOAD_HISTORY_FILTER_MAP.get(filterBy)));
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

}
