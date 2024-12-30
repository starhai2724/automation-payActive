package com.payactive.pages.cards;

import com.payactive.pages.CommonPage;
import org.openqa.selenium.By;

import static com.payactive.keywords.WebUI.verifyElementVisible;

/**
 * Page Object Model for the Direct Deposit Info Page.
 */
public class DirectDepositInfoPage extends CommonPage {

    /**
     * Locator for the deposit popup element.
     */
    private final By depositPopup = By.xpath("//*[@id=\"cdk-overlay-1\"]/nb-dialog-container/ngx-status-confirmation/nb-card/nb-card-body/div/div/div[1]/div/h6");

    private final By bankNameText = By.xpath("//*[@id=\"cdk-overlay-1\"]/nb-dialog-container/ngx-status-confirmation/nb-card/nb-card-body/div/div/div[1]/div/h6");
    private final By routingText = By.xpath("//*[@id=\"cdk-overlay-1\"]/nb-dialog-container/ngx-status-confirmation/nb-card/nb-card-body/div/div/div[2]/div/h6");
    private final By accountText = By.xpath("//*[@id=\"cdk-overlay-1\"]/nb-dialog-container/ngx-status-confirmation/nb-card/nb-card-body/div/div/div[3]/div/h6");

    public void verifyDepositPopupVisible() {
        verifyElementVisible(depositPopup);
    }

    public void verifyBankNameText() {
        verifyElementVisible(bankNameText);
    }

    public void verifyRoutingText() {
        verifyElementVisible(routingText);
    }

    public void verifyAccountText() {
        verifyElementVisible(accountText);
    }

}