package com.payactive.pages;

import org.openqa.selenium.By;

import static com.payactive.keywords.WebUI.clickElement;
import static com.payactive.keywords.WebUI.setText;

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

}
