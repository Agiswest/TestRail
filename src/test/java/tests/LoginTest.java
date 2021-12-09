package tests;

import adapters.BaseAdapter;
import adapters.ProjectAdapter;
import com.github.javafaker.Faker;
import models.*;
import org.testng.annotations.Test;
import pages.*;

public class LoginTest extends BaseTest {

    @Test
    public void loginTestPositive() {
        Project project = ProjectFactory.get();
        project.setSuiteMode("1");
        project.setId(projectAdapter.createProject(project).getId());
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.login(user, password);
        ProjectsPage projectsPage = new ProjectsPage();
        projectsPage.openProjectByUrl(project.getName(), project.getId());
        TestSuitesAndCasesPage testSuitesAndCasesPage = new TestSuitesAndCasesPage();
        String sectionName = new Faker().name().username();
        testSuitesAndCasesPage
                .open()
                .addCaseSection(sectionName);
        testSuitesAndCasesPage.caseSectionIsCreated(sectionName);
        projectAdapter.deleteProject(project.getId());

    }
}
