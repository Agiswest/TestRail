package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import wrappers.Input;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class LoginPage extends BasePage {
    private static final String EMAIL_INPUT = "name";
    private static final String PASSWORD_INPUT = "password";

    public boolean isLoginPageOpened() {
        log.info("Is login page opened");
        return $(By.id(EMAIL_INPUT)).shouldBe(Condition.visible).isDisplayed();
    }

    @Step("Open login page")
    public LoginPage open() {
        log.info("Login page is opened");
        Selenide.open("auth/login");
        $(By.id(PASSWORD_INPUT)).shouldBe(Condition.visible);
        return this;
    }

    @Step("Login using credentials: username - {user}, password - {pass}")
    public ProjectsPage login(String user, String pass) {
        log.info("Login by user: {}, password: {}", user, pass);
        new Input(EMAIL_INPUT).addText(user);
        new Input(PASSWORD_INPUT).addText(pass);
        $(By.id(PASSWORD_INPUT)).submit();
        return new ProjectsPage();
    }
}
