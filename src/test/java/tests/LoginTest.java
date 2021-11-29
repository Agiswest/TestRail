package tests;

import org.testng.annotations.Test;
import pages.*;

public class LoginTest extends BaseTest {

    @Test
    public void loginTestPositive() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.login(user, password);
        ProjectsPage projectsPage = new ProjectsPage();
        projectsPage.openProject("blabla");
        TestSuitesAndCasesPage testSuitesAndCasesPage = new TestSuitesAndCasesPage();
        testSuitesAndCasesPage.openPage();
        testSuitesAndCasesPage.addCase();

    }
}
