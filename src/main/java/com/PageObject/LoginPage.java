package com.PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class LoginPage {

    public static final String URL = "https://stellarburgers.nomoreparties.site/login";

    //заголовок Вход
    @FindBy(how = How.XPATH, using = ".//h2[text()='Вход']")
    private SelenideElement headEnter;
    //поле Email
    @FindBy(how = How.XPATH,using = "//*[text()='Email']/following-sibling::input")
    private SelenideElement emailField;

    //поле Пароль
    @FindBy(how = How.XPATH,using = "//*[text()='Пароль']/following-sibling::input")
    private SelenideElement passwordField;

    //кнопка Войти
    @FindBy(how = How.XPATH,using = ".//button[(text() = 'Войти')]")
    private SelenideElement loginAccountButton;

    //Зарегестрироваться
    @FindBy(how = How.XPATH,using = ".//a[(text() = 'Зарегистрироваться')]")
    private SelenideElement registerButton;

    //Восстановить пароль
    @FindBy(how = How.XPATH,using = ".//a[(text() = 'Восстановить пароль')]")
    private SelenideElement passwordRecoveryButton;

    //кнопка Оформить заказ
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    private SelenideElement createOrderButton;

    public boolean isLogInAccountButtonVisible() {
        loginAccountButton.shouldBe(Condition.visible);
        return true;
    }
    //метод логина
    public void login (String email, String password)  {
        emailField.shouldBe(Condition.exist).click();
        emailField.setValue(email);
        passwordField.click();
        passwordField.setValue(password);
        loginAccountButton.shouldBe(Condition.exist).click();
        createOrderButton.shouldBe(visible);
    }
}
