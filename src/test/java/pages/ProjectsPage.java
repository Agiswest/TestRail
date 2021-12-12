package pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class ProjectsPage extends BasePage {
    private static final String PROJECT_LOCATOR = "//div[contains(@id,'project')]/" +
            "descendant::a[contains(text(),'%s')]";
    private static final String CREATE_NEW_PROJECT_BUTTON = "#sidebar-projects-add";
    private static final String PAGE_TITLE = "//div[contains(text(),'All Projects')]";

    public boolean isProjectTitleVisible() {
        log.info("Is projects page title visible");
        return $x(PAGE_TITLE).isDisplayed();
    }

    @Step("Open project {projectName}")
    public OverviewPage openProjectByClick(String projectName) {
        log.info("Open project '{}' by click", projectName);
        $("body").sendKeys(Keys.CONTROL, Keys.END);
        $x(String.format(PROJECT_LOCATOR, projectName)).click();
        return new OverviewPage();
    }

    @Step("Open project {projectName}")
    public OverviewPage openProjectByUrl(String projectName, String idOfProject) {
        log.info("Open project '{}' by link {}", projectName, idOfProject);
        Selenide.open("projects/overview/" + idOfProject);
        return new OverviewPage();
    }

    @Step("Create new project")
    public CreateProjectPage createNewProject() {
        log.info("Create new project");
        $(CREATE_NEW_PROJECT_BUTTON).click();
        return new CreateProjectPage();
    }
}
