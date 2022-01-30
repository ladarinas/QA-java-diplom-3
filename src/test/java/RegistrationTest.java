import com.PageObject.LoginPage;
import com.PageObject.RegisterPage;
import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {
    @Before
    public void setUp() {
        Configuration.browser = "chrome";
        //System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
    }

    @Test
    public void successRegistration() {
        RegisterPage registerPage =  open(RegisterPage.URL, RegisterPage.class);
        LoginPage loginPage = registerPage.successRegistrationNewUser();
        assertTrue(loginPage.isLogInAccountButtonVisible());
    }

    @Test
    public void failRegistration() {
        RegisterPage registerPage =  open(RegisterPage.URL, RegisterPage.class);
        registerPage.failRegistrationNewUser();
        assertTrue(registerPage.isIncorrectPasswordTextVisible());
    }
}
