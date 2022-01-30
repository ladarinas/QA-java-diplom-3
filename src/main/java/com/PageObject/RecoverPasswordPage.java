package com.PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class RecoverPasswordPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    //Кнопка Войти
    @FindBy(how = How.XPATH,using = ".//a[(text() = 'Войти')]")
    private SelenideElement loginButton;

    public LoginPage clickLoginOnRecoverPasswordPage() {
        loginButton.shouldBe(Condition.exist).click();
        return page(LoginPage.class);
    }
}
