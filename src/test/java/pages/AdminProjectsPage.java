package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class AdminProjectsPage extends BasePage {

    @Step("Delete project {projectName}")
    public AdminProjectsPage deleteProject(String projectName) {
        log.info("Delete project '{}'", projectName);
        $x(String.format("//a[contains(text(),'%s')]" +
                "/ancestor::tr[contains(@class,'hoverSensitive')]" +
                "/descendant::div[contains(@class,'delete')]", projectName)).click();
        $x("(//*[@name='deleteCheckbox'])[3]").click();
        $x("(//*[@name='deleteCheckbox'])[3]" +
                "/ancestor::div[contains(@class,'dialog')]" +
                "/descendant::a[contains(text(),'OK')]").click();
        return this;
    }

    @Step("Rename {projectName} into {newProjectName}")
    public void editProjectName(String projectName, String newProjectName) {
        log.info("Rename project '{}' into '{}'", projectName, newProjectName);
        $x(String.format("//a[contains(text(),'%s')]", projectName)).click();
        new CreateProjectPage().editProjectName(newProjectName);
    }

    public String getSuccessMessage() {
        return $(".message-success").getText();
    }

    public boolean projectExists(String projectName) {
        log.info("Project '{}' exists", projectName);
        return $$x(String.format("//tr[contains(@class,'hoverSensitive')]" +
                "//a[contains(text(),'%s')][normalize-space(.)]", projectName)).size() != 0;
    }
}
