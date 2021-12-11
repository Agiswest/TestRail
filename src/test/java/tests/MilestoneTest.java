package tests;

import models.Milestone;
import models.MilestoneFactory;
import models.Project;
import models.ProjectFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MilestoneTest extends BaseTest {

    @Test(description = "Create milestone without parent milestone")
    public void createMilestoneTest() {
        Project project = ProjectFactory.get();
        Milestone milestone = MilestoneFactory.get();
        project.setSuiteMode("1");
        project.setId(projectAdapter.createProject(project).getId());
        loginPage
                .open()
                .login(user, password)
                .openProjectByUrl(project.getName(), project.getId());
        String successMessage =
                milestonesPage
                        .open()
                        .addMilestone()
                        .fillInfo(milestone)
                        .saveMilestone()
                        .getSuccessMessage();
        Assert.assertEquals(successMessage, "Successfully added the new milestone.",
                "Milestone not created");
        projectAdapter.deleteProject(project.getId());
    }
}
