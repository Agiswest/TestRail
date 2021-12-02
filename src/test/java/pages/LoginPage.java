package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private static final String EMAIL_INPUT = "#name";
    private static final String PASSWORD_INPUT = "#password";

    public LoginPage open() {
        Selenide.open("auth/login");
        $(PASSWORD_INPUT).shouldBe(Condition.visible);
        return this;
    }

    public ProjectsPage login(String user, String pass) {
        $(EMAIL_INPUT).sendKeys(user);
        $(PASSWORD_INPUT).sendKeys(pass);
        $(PASSWORD_INPUT).submit();
        return new ProjectsPage();
    }
}
