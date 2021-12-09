package tests;

import adapters.ProjectAdapter;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertyReader;

import java.lang.reflect.Method;

public class BaseTest {
    String user;
    String password;
    ProjectAdapter projectAdapter;

    @BeforeMethod
    public void setup(Method method) {
        String methodName = method.getName();
        ThreadContext.put("uuid", methodName);
        Configuration.timeout = 10000;
        //ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        //Configuration.browserCapabilities = chromeOptions;
        Configuration.browser = "chrome";
        Configuration.baseUrl = System.getenv().getOrDefault("TESTRAIL_URL",
                PropertyReader.getProperty("testrail.url"));
        Configuration.startMaximized = true;
        Configuration.headless = true;
        Configuration.clickViaJs = false;
        user = System.getenv().getOrDefault("TESTRAIL_USER",
                PropertyReader.getProperty("testrail.user"));
        password = System.getenv().getOrDefault("TESTRAIL_PASS",
                PropertyReader.getProperty("testrail.pass"));
        projectAdapter = new ProjectAdapter();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .includeSelenideSteps(false)
                .screenshots(true));
    }

    @AfterMethod
    public void closeDriver() {
        WebDriverRunner.closeWebDriver();
        ThreadContext.remove("uuid");
    }
}
