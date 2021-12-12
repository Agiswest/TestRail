package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Project;
import wrappers.Input;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class CreateProjectPage extends BasePage {
    private static final String SUITE_MODE_LOCATOR = "//*[contains(@id,'suite_mode_%s')]";
    private final String SAVE_PROJECT_BUTTON = "#accept";

    @Step("Fill info of project")
    public AdminProjectsPage fillInfoOfProject(Project project) {
        log.info("Fill info of project by data \"{}\"", project);
        new Input("name").addText(project.getName());
        new Input("announcement").addText(project.getAnnouncement());
        if (project.isShowAnnouncement()) {
            $("#show_announcement").click();
        }
        $x(String.format(SUITE_MODE_LOCATOR, project.getSuiteMode())).click();
        $(SAVE_PROJECT_BUTTON).click();
        return new AdminProjectsPage();
    }

    public void editProjectName(String projectName) {
        log.info("Rename project with new name '{}'", projectName);
        new Input("name").addText(projectName);
        $(SAVE_PROJECT_BUTTON).click();
    }
}
