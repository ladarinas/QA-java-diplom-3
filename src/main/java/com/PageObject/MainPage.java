package com.PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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
}
