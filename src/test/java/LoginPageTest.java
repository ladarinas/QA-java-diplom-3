import com.PageObject.LoginPage;
import com.PageObject.MainPage;
import com.PageObject.RecoverPasswordPage;
import com.PageObject.RegisterPage;
import com.UserOperations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class LoginPageTest {
    public  UserOperations userOperations;
    Map<String, String> response = new HashMap<>();

    @Before
    public void setUp() {
        userOperations = new UserOperations();
        response = userOperations.register();
    }

    @After
    public void tearDown() {
        userOperations.delete();
    }

    @Test
    public void loginClickButtonLoginInAccountOnMainPage() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        LoginPage loginPage = mainPage.clickLogInAccountButton();
        loginPage.login(response.get("email"),response.get("password"));
        assertTrue(mainPage.isOrderButtonVisible());
    }

    @Test
    public void loginClickButtonPersonalAccountOnMainPage() {
        MainPage mainPage = open(MainPage.URL, MainPage.class);
        LoginPage loginPage = mainPage.clickPersonalAccountButton();
        loginPage.login(response.get("email"),response.get("password"));
        assertTrue(mainPage.isOrderButtonVisible());
    }

    @Test
    public void loginClickButtonInRegisterPage() {
        RegisterPage registerPage =  open(RegisterPage.URL, RegisterPage.class);
        LoginPage loginPage = registerPage.clickLoginButtonOnRegisterPage();
        loginPage.login(response.get("email"),response.get("password"));
        MainPage mainPage = page(MainPage.class);
        assertTrue(mainPage.isOrderButtonVisible());
    }

    @Test
    public void loginClickButtonOnRecoverPasswordPage() {
        RecoverPasswordPage recoverPasswordPage = open(RecoverPasswordPage.URL, RecoverPasswordPage.class);
        LoginPage loginPage = recoverPasswordPage.clickLoginOnRecoverPasswordPage();
        loginPage.login(response.get("email"),response.get("password"));
        MainPage mainPage = page(MainPage.class);
        assertTrue(mainPage.isOrderButtonVisible());
    }

}
