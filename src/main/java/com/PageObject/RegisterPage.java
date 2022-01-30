package com.PageObject;

import com.codeborne.selenide.Condition;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class RegisterPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/register";

    //поле Имя
    @FindBy(how = How.XPATH,using = "(//*[contains(@class, 'input pr-6 pl-6')]/input)[1]")
    private SelenideElement nameRegisterField;

    //поле Email
    @FindBy(how = How.XPATH,using = "(//*[contains(@class, 'input pr-6 pl-6')]/input)[2]")
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

    //заголовок Вход
    @FindBy(how = How.XPATH, using = ".//h2[text()='Вход']")
    private SelenideElement enterText;

    public LoginPage clickLoginButtonOnRegisterPage() {
        loginButton.click();
        return page(LoginPage.class);
    }

    public boolean isEnterTextVisible(){
        enterText.shouldBe(Condition.visible);
        return true;
    }

    public boolean isIncorrectPasswordTextVisible(){
        incorrectPasswordText.shouldBe(Condition.visible);
        return true;
    }

    public LoginPage successRegistrationNewUser() {
        nameRegisterField.setValue(RandomStringUtils.randomAlphabetic(10));
        emailRegisterField.setValue(RandomStringUtils.randomAlphabetic(10) + "@yandex.ru");
        passwordRegisterField.setValue(RandomStringUtils.randomAlphabetic(6));
        registerButton.click();
        enterText.shouldBe(Condition.visible);
        return page(LoginPage.class);
    }

    public RegisterPage failRegistrationNewUser() {
        nameRegisterField.setValue(RandomStringUtils.randomAlphabetic(10));
        emailRegisterField.setValue(RandomStringUtils.randomAlphabetic(10) + "@yandex.ru");
        passwordRegisterField.setValue(RandomStringUtils.randomAlphabetic(5));
        registerButton.click();
        incorrectPasswordText.shouldBe(Condition.visible);
        return this;
    }

}
