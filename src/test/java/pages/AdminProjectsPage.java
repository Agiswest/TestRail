package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertNotNull;

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

    public String getIdOfProject(String projectName) {
        String attributeText = $x(String.format("//a[contains(text(),'%s')]", projectName))
                .getAttribute("href");
        assertNotNull(attributeText);
        String[] linkComponents = attributeText.split("/");
        return linkComponents[7];
    }

    @Step("Rename {projectName} into {newProjectName}")
    public AdminProjectsPage editProjectName(String projectName, String newProjectName) {
        log.info("Rename project '{}' into '{}'", projectName, newProjectName);
        $x(String.format("//a[contains(text(),'%s')]", projectName)).click();
        new CreateProjectPage().editProjectName(newProjectName);
        return this;
    }

    public String getSuccessMessage() {
        return $(".message-success").getText();
    }

    public boolean isProjectExists(String projectName) {
        log.info("Project '{}' exists", projectName);
        return $$x(String.format("//tr[contains(@class,'hoverSensitive')]" +
                "//a[contains(text(),'%s')][normalize-space(.)]", projectName)).size() != 0;
    }
}
