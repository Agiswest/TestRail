package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.*;

public class LoginTest extends BaseTest {

    @Test
    public void loginTestPositive() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.login(user, password);
        ProjectsPage projectsPage = new ProjectsPage();
        projectsPage.openProjectByUrl("TestExampleProject");
        TestSuitesAndCasesPage testSuitesAndCasesPage = new TestSuitesAndCasesPage();
        String sectionName = new Faker().name().username();
        testSuitesAndCasesPage
                .open()
                .addCaseSection(sectionName);
        testSuitesAndCasesPage.caseSectionIsCreated(sectionName);

    }
}
