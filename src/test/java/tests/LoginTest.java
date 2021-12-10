package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Login with valid credentials")
    public void loginTestPositive() {
        boolean overviewPageIsOpened =
        loginPage
                .open()
                .login(user, password)
                .isProjectTitleVisible();
        Assert.assertTrue(overviewPageIsOpened, "Login credentials are invalid");
    }
}
