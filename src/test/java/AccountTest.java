import com.PageObject.LoginPage;
import com.PageObject.MainPage;
import com.UserOperations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AccountTest {
    public UserOperations userOperations;
    Map<String, String> response = new HashMap<>();

    @Before
    public void setUp() {
        userOperations = new UserOperations();
        response = userOperations.register();
    }

    @After
    public void tearDown (){
        userOperations.delete();
    }

    @Test
    public void goToPersonalAccount() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        LoginPage loginPage = mainPage.clickPersonalAccountButton();
        loginPage.login(response.get("email"),response.get("password"));
        mainPage.clickPersonalAccountButton();
        assertTrue(mainPage.isProfileButtonVisible());
        String actualNameValue = mainPage.getNameValue();
        String expectedName = response.get("name");
        assertEquals(expectedName, actualNameValue);
    }

    @Test
    public void goFromPersonalAccountToConstructorClickLogo() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        LoginPage loginPage = mainPage.clickPersonalAccountButton();
        loginPage.login(response.get("email"),response.get("password"));
        mainPage.clickPersonalAccountButton();
        assertTrue(mainPage.isProfileButtonVisible());
        mainPage.clickLogoButton();
        String actualText = mainPage.getConstructorText();
        String expectedText = "Соберите бургер";
        assertEquals (expectedText, actualText);
    }

    @Test
    public void goFromPersonalAccountToConstructorClickConstructor() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        LoginPage loginPage = mainPage.clickPersonalAccountButton();
        loginPage.login(response.get("email"),response.get("password"));
        mainPage.clickPersonalAccountButton();
        assertTrue(mainPage.isProfileButtonVisible());
        mainPage.clickConstructorButton();
        String actualText = mainPage.getConstructorText();
        String expectedText = "Соберите бургер";
        assertEquals (expectedText, actualText);
    }

    @Test
    public void successLogout() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        LoginPage loginPage = mainPage.clickLogInAccountButton();
        loginPage.login(response.get("email"),response.get("password"));
        mainPage.clickPersonalAccountButton();
        mainPage.clickLogoutButton();
        assertTrue(mainPage.isEnterTextVisible());
    }
}
