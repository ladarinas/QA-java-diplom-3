import com.PageObject.MainPage;

import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class MainPageTest {

    @Before
    public void setUp() {
          Configuration.browser = "chrome";
        //System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
    }

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
        mainPage.clickSaucesButton();
        assertTrue(mainPage.isIngredientsListSauceVisible());
    }

    @Test
    public void goToFilling() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        mainPage.clickFillingsButton();
        assertTrue(mainPage.isIngredientsFillingVisible());
    }


}
