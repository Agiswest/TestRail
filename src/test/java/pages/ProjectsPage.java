package pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class ProjectsPage extends BasePage {
    private static final String PROJECT_LOCATOR = "//div[contains(@id,'project')]/" +
            "descendant::a[contains(text(),'%s')]";
    private static final String CREATE_NEW_PROJECT_BUTTON = "#sidebar-projects-add";

    @Step("Open project {projectName}")
    public OverviewPage openProjectByClick(String projectName) {
        $("body").sendKeys(Keys.CONTROL, Keys.END);
        $x(String.format(PROJECT_LOCATOR, projectName)).click();
        return new OverviewPage();
    }

    @Step("Open project {projectName}")
    public OverviewPage openProjectByUrl(String projectName) {
        String attributeText = $x(String.format(PROJECT_LOCATOR, projectName)).getAttribute("href");
        assert attributeText != null;
        String[] linkComponents = attributeText.split("/");
        String idOfProject = linkComponents[6];
        Selenide.open("projects/overview/" + idOfProject);
        return new OverviewPage();
    }

    @Step("Create new project")
    public CreateProjectPage createNewProject() {
        $(CREATE_NEW_PROJECT_BUTTON).click();
        return new CreateProjectPage();
    }
}
