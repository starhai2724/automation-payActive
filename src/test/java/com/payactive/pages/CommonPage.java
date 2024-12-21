package com.payactive.pages;

import com.payactive.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.payactive.keywords.WebUI.setTextAndKey;

public class CommonPage {
    private By menuProducts = By.xpath("//span[normalize-space()='Products']");

    private By messageNotify = By.xpath("//span[@data-notify='message']");

    private By buttonEdit = By.xpath("(//a[@title='Edit'])[1]");
    private By inputSearch = By.xpath("//input[@id='search']");
    public By avatarProfile = By.xpath("//span[contains(@class,'avatar avatar-sm')]");


    public void searchDataTable(String dataName) {
        setTextAndKey(inputSearch, dataName, Keys.ENTER);
    }

    public void clickEditButton() {
        WebUI.clickElement(buttonEdit);
    }

    public String getMessageNotify() {
        return WebUI.getElementText(messageNotify);
    }

    public void clickMenuProducts() {
        WebUI.clickElement(menuProducts);
    }

}
