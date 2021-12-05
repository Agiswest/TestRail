package pages;

import models.Project;
import wrappers.Input;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CreateProjectPage extends BasePage {

    public AdminProjectsPage fillInfoOfProject(Project project) {
        new Input("name").addText(project.getName());
        new Input("announcement").addText(project.getAnnouncement());
        if (project.isShowAnnouncement()) {
            $("#show_announcement").click();
        }
        $x(String.format("//*[contains(@id,'suite_mode_%s')]", project.getSuiteMode())).click();
        $("#accept").click();
        return new AdminProjectsPage();
    }

    public AdminProjectsPage editProjectName(String projectName) {
        new Input("name").addText(projectName);
        $("#accept").click();
        return new AdminProjectsPage();
    }
}
