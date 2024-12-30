package com.payactive.pages.cards;

import com.payactive.keywords.WebUI;
import com.payactive.pages.CommonPage;
import org.openqa.selenium.By;

public class CardHolderActionPage extends CommonPage {

    private final By actionButton = By.xpath("//*[@id=\"app-theme\"]/nb-layout/div/div/div/div/div/nb-layout-column/ngx-components/ngx-cardholders/mat-drawer-container/mat-drawer-content/div/nb-card/nb-card-body/div[3]/ng2-smart-table/table/tbody/tr[1]/td[9]/ng2-smart-table-cell/table-cell-view-mode/div/custom-view-component/ngx-card-holder-select-view/nb-select/button");
    private final By accountInfoOption = By.xpath("//nb-option[@value='1']");

    public void clickActionButton() {
        WebUI.clickElement(actionButton);
    }

    public void clickAccountInfoOption() {
        WebUI.clickElement(accountInfoOption);
    }

}
