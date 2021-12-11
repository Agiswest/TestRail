package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test(description = "User can logout")
    public void logoutTestPositive() {
        boolean loginPageIsOpened =
                loginPage
                        .open()
                        .login(user, password)
                        .logout()
                        .isLoginPageOpened();
        Assert.assertTrue(loginPageIsOpened, "Login page wasn't opened");
    }
}
