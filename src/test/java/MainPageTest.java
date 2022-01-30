import com.PageObject.LoginPage;
import com.PageObject.MainPage;

import com.UserOperations;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class MainPageTest {

//    @Before
//    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
//    }

    @Test
    public void goToBun() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        mainPage.clickFillingsButton();
        mainPage.clickBunButton();
        assertTrue(mainPage.isIngredientsListBunVisible());
    }

    @Test
    public void goToSauces() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        assertTrue(mainPage.isIngredientsListBunVisible());
        mainPage.clickSaucesButton();
        assertTrue(mainPage.isIngredientsListSauceVisible());
    }

    @Test
    public void goToFilling() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        assertTrue(mainPage.isIngredientsListBunVisible());
        mainPage.clickFillingsButton();
        assertTrue(mainPage.isIngredientsFillingVisible());
    }


}
