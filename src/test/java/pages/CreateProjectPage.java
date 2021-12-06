package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Project;
import wrappers.Input;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class CreateProjectPage extends BasePage {

    @Step("Fill info of project")
    public AdminProjectsPage fillInfoOfProject(Project project) {
        log.info("Fill info of project by data '{}'", project);
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
        log.info("Rename project with new name '{}'", projectName);
        new Input("name").addText(projectName);
        $("#accept").click();
        return new AdminProjectsPage();
    }
}
