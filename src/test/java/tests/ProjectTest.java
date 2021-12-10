package tests;

import models.Project;
import models.ProjectFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {
    Project project;

    @Test(description = "User can create the project")
    public void createProjectTest() {
        project = ProjectFactory.get();
        boolean projectExists =
        loginPage
                .open()
                .login(user, password)
                .createNewProject()
                .fillInfoOfProject(project)
                .isProjectExists(project.getName());
        Assert.assertTrue(projectExists, "Project wasn't created");
        project.setId(adminProjectsPage.getIdOfProject(project.getName()));
        Assert.assertEquals(adminProjectsPage.getSuccessMessage(),
                "Successfully added the new project.", "Project wasn't created");
        projectAdapter.deleteProject(project.getId());
    }

    @Test(description = "User can rename the project")
    public void editProjectNameTest() {
        project = ProjectFactory.get();
        boolean projectExists =
                loginPage
                        .open()
                        .login(user, password)
                        .createNewProject()
                        .fillInfoOfProject(project)
                        .editProjectName(project.getName(), "Test Project")
                        .isProjectExists("Test Project");
        Assert.assertTrue(projectExists, "Project wasn't renamed");
        project.setId(adminProjectsPage.getIdOfProject("Test Project"));
        Assert.assertEquals(adminProjectsPage.getSuccessMessage(),
                "Successfully updated the project.", "Project wasn't renamed");
        projectAdapter.deleteProject(project.getId());
    }

    @Test(description = "User can delete the project")
    public void deleteProjectTest() {
        project = ProjectFactory.get();
        boolean projectExists =
                loginPage
                        .open()
                        .login(user, password)
                        .createNewProject()
                        .fillInfoOfProject(project)
                        .deleteProject(project.getName())
                        .isProjectExists(project.getName());
        Assert.assertFalse(projectExists, "Project wasn't deleted");
        Assert.assertEquals(adminProjectsPage.getSuccessMessage(),
                "Successfully deleted the project.", "Project wasn't deleted");
    }
}
