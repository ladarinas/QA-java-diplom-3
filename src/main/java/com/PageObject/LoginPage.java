package com.PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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
    private SelenideElement logInAccountButton;

    //Зарегестрироваться
    @FindBy(how = How.XPATH,using = ".//a[(text() = 'Зарегистрироваться')]")
    private SelenideElement registerButton;

    //Восстановить пароль
    @FindBy(how = How.XPATH,using = ".//a[(text() = 'Восстановить пароль')]")
    private SelenideElement passwordRecoveryButton;
}
