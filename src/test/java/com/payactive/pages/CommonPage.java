package com.payactive.pages;

import com.payactive.driver.DriverManager;
import com.payactive.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.payactive.keywords.WebUI.*;

public class CommonPage {
    private By menuProducts = By.xpath("//span[normalize-space()='Products']");

    private By messageNotify = By.xpath("//span[@data-notify='message']");

    private By buttonEdit = By.xpath("(//a[@title='Edit'])[1]");
    private By inputSearch = By.xpath("//input[@id='search']");
    public By avatarProfile = By.xpath("//span[contains(@class,'avatar avatar-sm')]");

    private final By cardDropdown = By.xpath("//*[@id=\"sidebar-hide\"]/div/div/nb-menu/ul/li[6]/a");

    public final By spinnerLoading = By.xpath("//nb-spinner[contains(@class, 'size-medium') and contains(@class, 'status-basic')]//span[contains(@class, 'spin-circle')]");

    public void searchDataTable(String dataName) {
        setTextAndKey(inputSearch, dataName, Keys.ENTER);
    }

    public void clickEditButton() {
        clickElement(buttonEdit);
    }

    public String getMessageNotify() {
        return WebUI.getElementText(messageNotify);
    }

    public void clickMenuProducts() {
        clickElement(menuProducts);
    }

    public void clickCardDropdown() {
        clickElement(cardDropdown);
    }

    public void userOnThePage(String title) {
        verifyEquals(DriverManager.getDriver().getTitle(), title);
    }

    public void waitForSpinnerLoading() {
        WebUI.waitForElementPresent(spinnerLoading);
        WebUI.waitForElementNotPresent(spinnerLoading);
    }
}
