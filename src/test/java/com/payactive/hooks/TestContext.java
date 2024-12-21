package com.payactive.hooks;

import com.payactive.driver.DriverFactory;
import com.payactive.driver.DriverManager;
import com.payactive.pages.*;
import com.payactive.pages.cards.CardHolderPage;
import com.payactive.utils.LogUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class TestContext {

    private WebDriver driver;
    private CommonPage commonPage;
    private LoginPage loginPage;

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

    public CardHolderPage getCardHolderPage() {
        return new CardHolderPage();
    }

    public WebDriver getDriver() {
        return DriverManager.getDriver();
    }
}
