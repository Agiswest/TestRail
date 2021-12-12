package tests;

import com.github.javafaker.Faker;
import models.Case;
import models.CaseFactory;
import models.Project;
import models.ProjectFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CaseTest extends BaseTest {
    Project project;
    Case caseData;

    @Test(description = "Case can be created")
    public void createCaseTest() {
        project = ProjectFactory.get();
        project.setSuiteMode("1");
        caseData = CaseFactory.get();
        project.setId(projectAdapter.createProject(project).getId());
        loginPage
                .open()
                .login(user, password)
                .openProjectByUrl(project.getName(), project.getId());
        String confirmationMessage =
                testSuitesAndCasesPage
                        .open()
                        .addCase()
                        .fillInfo(caseData)
                        .getConfirmationMessage();
        Assert.assertEquals(confirmationMessage, "Successfully added the new test case. Add another");
        projectAdapter.deleteProject(project.getId());
    }

    @Test(description = "User can create test section")
    public void createTestSectionTest() {
        project = ProjectFactory.get();
        String sectionName = new Faker().name().username();
        project.setSuiteMode("1");
        project.setId(projectAdapter.createProject(project).getId());
        loginPage
                .open()
                .login(user, password)
                .openProjectByUrl(project.getName(), project.getId());
        testSuitesAndCasesPage
                .open()
                .addCaseSection(sectionName);
        Assert.assertTrue(testSuitesAndCasesPage.isCaseSectionCreated(sectionName),
                "Case section wasn't created");
        projectAdapter.deleteProject(project.getId());
    }

    @Test(description = "Case can be deleted")
    public void deleteCaseTest() {
        project = ProjectFactory.get();
        project.setSuiteMode("1");
        caseData = CaseFactory.get();
        project.setId(projectAdapter.createProject(project).getId());
        loginPage
                .open()
                .login(user, password)
                .openProjectByUrl(project.getName(), project.getId());
        testSuitesAndCasesPage
                .open()
                .addCase()
                .fillInfo(caseData);
        boolean caseExists =
                testSuitesAndCasesPage
                        .open()
                        .deleteCase(caseData.getTitle())
                        .isCaseExists(caseData.getTitle());
        Assert.assertFalse(caseExists, "Case wasn't deleted");
        projectAdapter.deleteProject(project.getId());
    }
}
