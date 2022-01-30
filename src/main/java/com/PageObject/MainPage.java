package com.PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    //кнопка Войти в аккаунт
    @FindBy(how = How.XPATH, using = ".//button[(text() = 'Войти в аккаунт')]")
    private SelenideElement logInAccountButton;
    
    // кнопка Выход
    @FindBy(how = How.XPATH, using = ".//button[text()='Выход']")
    private SelenideElement logoutButton;

    //кнопка Личный кабинет
    @FindBy(how = How.XPATH,using = ".//p[(text() = 'Личный Кабинет')]")
    private SelenideElement personalAccountButton;

    //кнопка Оформить заказ
    @FindBy(how = How.XPATH, using = ".//button[(text() = 'Оформить заказ')]")
    private SelenideElement orderButton;

    //заголовок Соберите бургер
    @FindBy(how = How.XPATH, using = ".//h1[(text() = 'Соберите бургер')]")
    private SelenideElement constructorText;

    //логотип
    @FindBy(how = How.XPATH, using = ".//div[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement logoButton;

    // кнопка Булки
    @FindBy(how = How.XPATH, using = "//span[text()='Булки']")
    private SelenideElement bunButton;

    // кнопка Начинки
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement fillingButton;

    // кнопка Соусы
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement sauceButton;

    // кнопка Конструктор
    @FindBy(how = How.XPATH, using = ".//p[text()='Конструктор']")
    private SelenideElement constructButton;

    //ингридиенты
    @FindAll({@FindBy(how = How.XPATH, using = ".//ul[@class='BurgerIngredients_ingredients__list__2A-mT']")})
    private ElementsCollection ingredientsList;

    //заголовок Вход
    @FindBy(how = How.XPATH, using = ".//h2[text()='Вход']")
    private SelenideElement enterText;

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

    public void clickBunButton() {
        bunButton.shouldBe(Condition.visible).click();
    }
    public void clickSaucesButton() {
        sauceButton.shouldBe(Condition.visible).click();
    }
    public void clickFillingsButton() {
        fillingButton.shouldBe(Condition.visible).click();
    }

    public boolean isIngredientsListBunVisible() {
        return $(ingredientsList.get(0)).isDisplayed();
    }

    public boolean isIngredientsListSauceVisible() {
        return $(ingredientsList.get(1)).isDisplayed();
    }

    public boolean isIngredientsFillingVisible() {
        return $(ingredientsList.get(2)).isDisplayed();
    }

    public LoginPage clickLogoutButton() {
        logoutButton.click();
        return page(LoginPage.class);
    }

    public boolean isEnterTextVisible() {
        enterText.shouldBe(Condition.visible);
        return true;
    }
}
