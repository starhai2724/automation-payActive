package com.payactive.pages.cards;

import org.openqa.selenium.By;

import static com.payactive.keywords.WebUI.clickElement;

public class CardHolderPage {

    private final By cardDropdown = By.xpath("//*[@id=\"sidebar-hide\"]/div/div/nb-menu/ul/li[6]/a");
    private final By carHolder = By.xpath("//*[@id=\"sidebar-hide\"]/div/div/nb-menu/ul/li[6]/ul/li[1]/a");


    public void clickCardDropdown() {
        clickElement(cardDropdown);
    }

    public void clickCardHolder() {
        clickElement(carHolder);
    }

}
