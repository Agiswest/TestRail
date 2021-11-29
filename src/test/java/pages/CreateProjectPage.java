package pages;

import models.Project;
import wrappers.Input;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CreateProjectPage extends BasePage {

    public void fillInfoOfProject(Project project) {
        new Input("name").addText(project.getName());
        new Input("announcement").addText(project.getAnnouncement());
        if (project.isShowAnnouncement()) {
            $("#show_announcement").click();
        }
        $x(String.format("//*[contains(@id,'suite_mode_%s')]", project.getSuiteMode())).click();
        $("#accept").click();
    }
}
