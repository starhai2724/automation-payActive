package com.payactive.pages.cards;

import com.payactive.pages.CommonPage;
import org.openqa.selenium.By;

import static com.payactive.keywords.WebUI.clickElement;

public class CardHamburgerMenuPage extends CommonPage {

    private final By cardDropdown = By.xpath("//*[@id=\"sidebar-hide\"]/div/div/nb-menu/ul/li[6]/a");
    private final By cardHolder = By.xpath("//*[@id=\"sidebar-hide\"]/div/div/nb-menu/ul/li[6]/ul/li[1]/a");
    private final By loadHistory = By.xpath("//*[@id=\"sidebar-hide\"]/div/div/nb-menu/ul/li[6]/ul/li[4]/a");

    /**
     * Clicks on the card dropdown menu.
     */
    public void clickCardDropdown() {
        clickElement(cardDropdown);
    }

    /**
     * Clicks on the card holder menu item.
     */
    public void clickCardHolder() {
        clickElement(cardHolder);
    }

    /**
     * Clicks on the load history menu item.
     */
    public void clickLoadHistory() {
        clickElement(loadHistory);
    }
}
