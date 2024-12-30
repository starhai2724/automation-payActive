package com.payactive.hooks;

import com.payactive.driver.DriverFactory;
import com.payactive.driver.DriverManager;
import com.payactive.pages.*;
import com.payactive.pages.cards.*;
import com.payactive.utils.LogUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class TestContext {

    private WebDriver driver;
    private CommonPage commonPage;
    private LoginPage loginPage;
    private FilterCardHolderPage filterCardHolderPage;
    private CardHolderPage cardHolderPage;
    private CardHolderActionPage cardHolderActionPage;
    private CardHamburgerMenuPage cardHamburgerMenuPage;
    private DirectDepositInfoPage directDepositInfoPage;
    private LoadHistoryPage loadHistoryPage;
    private FilterLoadHistoryPage filterLoadHistoryPage;

    public TestContext() {
        ThreadGuard.protect(new DriverFactory().createDriver());
        LogUtils.info("Driver in TestContext: " + getDriver());
    }

    public CommonPage getCommonPage() {
        if (commonPage == null) {
            commonPage = new CommonPage();
        }
        return commonPage;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public FilterCardHolderPage getFilterPage() {
        if (filterCardHolderPage == null) {
            filterCardHolderPage = new FilterCardHolderPage();
        }
        return filterCardHolderPage;
    }

    public CardHolderPage getCardHolderPage() {
        if (cardHolderPage == null) {
            cardHolderPage = new CardHolderPage();
        }
        return cardHolderPage;
    }

    public CardHolderActionPage getCardHolderActionPage() {
        if (cardHolderActionPage == null) {
            cardHolderActionPage = new CardHolderActionPage();
        }
        return cardHolderActionPage;
    }

    public CardHamburgerMenuPage getCardHamburgerMenuPage() {
        if (cardHamburgerMenuPage == null) {
            cardHamburgerMenuPage = new CardHamburgerMenuPage();
        }
        return cardHamburgerMenuPage;
    }

    public DirectDepositInfoPage getDirectDepositInfoPage() {
        if (directDepositInfoPage == null) {
            directDepositInfoPage = new DirectDepositInfoPage();
        }
        return directDepositInfoPage;
    }

    public LoadHistoryPage getLoadHistoryPage() {
        if (loadHistoryPage == null) {
            loadHistoryPage = new LoadHistoryPage();
        }
        return loadHistoryPage;
    }

    public FilterLoadHistoryPage getFilterHistoryPage() {
        if (filterLoadHistoryPage == null) {
            filterLoadHistoryPage = new FilterLoadHistoryPage();
        }
        return filterLoadHistoryPage;
    }

    public WebDriver getDriver() {
        return DriverManager.getDriver();
    }
}
