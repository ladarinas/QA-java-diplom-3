import com.PageObject.LoginPage;
import com.PageObject.MainPage;
import com.UserOperations;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class AccountTest {
    public UserOperations userOperations;
    Map<String, String> response = new HashMap<>();

    @Before
    public void setUp() {
        userOperations = new UserOperations();
        response = userOperations.register();
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
