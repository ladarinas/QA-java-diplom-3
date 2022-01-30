import com.PageObject.LoginPage;
import com.PageObject.RegisterPage;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {
    @Test
    public void successRegistration() {
        RegisterPage registerPage =  open(RegisterPage.URL, RegisterPage.class);
        LoginPage loginPage = registerPage.successRegistrationNewUser();
        assertTrue(loginPage.isLogInAccountButtonVisible());
    }

    @Test
    public void failRegistration() {
        RegisterPage registerPage =  open(RegisterPage.URL, RegisterPage.class);
        RegisterPage loginPage  = registerPage.failRegistrationNewUser();
        assertTrue(registerPage.isIncorrectPasswordTextVisible());
    }
}
