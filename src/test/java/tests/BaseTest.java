package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertyReader;

public class BaseTest {
    String user;
    String password;

    @BeforeMethod
    public void setup() {
        Configuration.timeout = 10000;
        Configuration.browser = "chrome";
        Configuration.baseUrl = System.getenv().getOrDefault("TESTRAIL_URL",
                PropertyReader.getProperty("testrail.url"));
        Configuration.startMaximized = true;
        Configuration.headless = false;
        Configuration.clickViaJs = false;
        user = System.getenv().getOrDefault("TESTRAIL_USER",
                PropertyReader.getProperty("testrail.user"));
        password = System.getenv().getOrDefault("TESTRAIL_PASS",
                PropertyReader.getProperty("testrail.pass"));
    }

    @AfterMethod
    public void closeDriver() {
        WebDriverRunner.closeWebDriver();
    }
}
