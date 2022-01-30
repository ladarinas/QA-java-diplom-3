package com.PageObject;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.page;

public class RegisterPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/register";

    //поле Имя
    @FindBy(how = How.XPATH,using = "(//*[text()='Имя']/following-sibling::input")
    private SelenideElement nameRegisterField;

    //поле Email
    @FindBy(how = How.XPATH,using = "(//*[text()='Email']/following-sibling::input")
    private SelenideElement emailRegisterField;

    //поле Пароль
    @FindBy(how = How.XPATH,using = ".//input[@name = 'Пароль']")
    private SelenideElement passwordRegisterField;

    //ошибка
    @FindBy(how = How.XPATH,using = ".//p[text()='Некорректный пароль']")
    private SelenideElement incorrectPasswordText;

    //кнопка Зарегестрироваться
    @FindBy(how = How.XPATH,using = ".//button[(text() = 'Зарегистрироваться')]")
    private SelenideElement registerButton;

    //кнопка Войти
    @FindBy(how = How.XPATH,using = ".//a[(text() = 'Войти')]")
    private SelenideElement loginButton;

    public LoginPage clickLoginButtonOnRegisterPage() {
        loginButton.click();
        return page(LoginPage.class);
    }

}
