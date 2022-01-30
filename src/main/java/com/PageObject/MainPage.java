package com.PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class MainPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    //кнопка Войти в аккаунт
    @FindBy(how = How.XPATH, using = ".//button[(text() = 'Войти в аккаунт')]")
    private SelenideElement logInAccountButton;

    //кнопка Личный кабинет
    @FindBy(how = How.XPATH,using = ".//p[(text() = 'Личный Кабинет')]")
    private SelenideElement personalAccountButton;

    //кнопка Оформить заказ
    @FindBy(how = How.XPATH, using = ".//button[(text() = 'Оформить заказ')]")
    private SelenideElement orderButton;

    //заголовок Соберите бургер
    @FindBy(how = How.XPATH, using = ".//h1[(text() = 'Соберите бургер')]")
    private SelenideElement constructorText;


    public LoginPage clickLogInAccountButton() {
        logInAccountButton.click();
        return page(LoginPage.class);
    }

    public boolean isOrderButtonVisible(){
        orderButton.shouldBe(Condition.visible);
        return true;
    }

    public LoginPage clickPersonalAccountButton() {
        personalAccountButton.click();
        return page(LoginPage.class);
    }
}
