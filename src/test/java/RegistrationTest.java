import com.PageObject.LoginPage;
import com.PageObject.RegisterPage;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
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
    @Description("Успешная регистрация")
    public void successRegistration() {
        RegisterPage registerPage =  open(RegisterPage.URL, RegisterPage.class);
        LoginPage loginPage = registerPage.successRegistrationNewUser();
        assertTrue("не удалось пройти регистрацию", loginPage.isLogInAccountButtonVisible());
    }

    @Test
    @Description("Ошибка некорректного пароля")
    public void failRegistration() {
        RegisterPage registerPage =  open(RegisterPage.URL, RegisterPage.class);
        registerPage.failRegistrationNewUser();
        assertTrue("ошибка некорректного пароля не отображается", registerPage.isIncorrectPasswordTextVisible());
    }
}
