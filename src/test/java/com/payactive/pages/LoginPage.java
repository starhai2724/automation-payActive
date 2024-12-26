package com.payactive.pages;

import com.payactive.common.DataCommon;
import com.payactive.constants.ConstantGlobal;
import com.payactive.driver.DriverManager;
import com.payactive.keywords.WebUI;
import com.payactive.models.Credentials;
import org.openqa.selenium.By;

import static com.payactive.keywords.WebUI.*;

public class LoginPage extends CommonPage {

    private final By inputEmail = By.id("user-name");
    private final By inputPassword = By.id("password");
    private final By buttonLogin = By.xpath("//*[@id=\"create-account-content-area\"]/div[2]/div[6]/button");

    public void enterEmailAndPassword(String email, String password) {
        setText(inputEmail, email);
        setText(inputPassword, password);
    }

    public void clickLoginButton() {
        clickElement(buttonLogin);
    }

    public void login() {
        openURL(ConstantGlobal.URL);
        Credentials credentials = DataCommon.credentialsList.getFirst();
        setText(inputEmail, credentials.getUsername());
        setText(inputPassword, credentials.getPassword());
        clickLoginButton();
    }

}
