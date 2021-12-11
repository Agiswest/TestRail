package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertNotNull;

@Log4j2
public class AdminProjectsPage extends BasePage {
    private static final String DELETE_PROJECT_BUTTON = "//a[contains(text(),'%s')]" +
            "/ancestor::tr[contains(@class,'hoverSensitive')]" +
            "/descendant::div[contains(@class,'delete')]";
    private static final String CONFIRM_DELETE_CHECKBOX = "(//*[@name='deleteCheckbox'])[3]";
    private static final String FINALLY_DELETE_PROJECT = "(//*[@name='deleteCheckbox'])[3]" +
            "/ancestor::div[contains(@class,'dialog')]" +
            "/descendant::a[contains(text(),'OK')]";
    private final String PROJECT_NAME_LOCATOR = "//tr[contains(@class,'hoverSensitive')]" +
            "//a[contains(text(),'%s')][normalize-space(.)]";

    @Step("Delete project {projectName}")
    public AdminProjectsPage deleteProject(String projectName) {
        log.info("Delete project '{}'", projectName);
        $x(String.format(DELETE_PROJECT_BUTTON, projectName)).click();
        $x(CONFIRM_DELETE_CHECKBOX).click();
        $x(FINALLY_DELETE_PROJECT).click();
        return this;
    }

    public String getIdOfProject(String projectName) {
        String attributeText = $x(String.format(PROJECT_NAME_LOCATOR, projectName))
                .getAttribute("href");
        assertNotNull(attributeText);
        String[] linkComponents = attributeText.split("/");
        return linkComponents[7];
    }

    @Step("Rename {projectName} into {newProjectName}")
    public AdminProjectsPage editProjectName(String projectName, String newProjectName) {
        log.info("Rename project '{}' into '{}'", projectName, newProjectName);
        $x(String.format(PROJECT_NAME_LOCATOR, projectName)).click();
        new CreateProjectPage().editProjectName(newProjectName);
        return this;
    }

    public String getSuccessMessage() {
        return $(".message-success").getText();
    }

    public boolean isProjectExists(String projectName) {
        log.info("Project '{}' exists", projectName);
        return $$x(String.format(PROJECT_NAME_LOCATOR, projectName)).size() != 0;
    }
}
