package pages;

import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class ProjectsPage extends BasePage {
    private static final String PROJECT_LOCATOR = "//div[contains(@id,'project')]/" +
            "descendant::a[contains(text(),'%s')]";
    private static final String CREATE_NEW_PROJECT_BUTTON = "#sidebar-projects-add";

    public OverviewPage openProject(String projectName) {
        $("body").sendKeys(Keys.CONTROL, Keys.END);
        $x(String.format(PROJECT_LOCATOR, projectName)).click();
        return new OverviewPage();
    }

    public CreateProjectPage createNewProject() {
        $(CREATE_NEW_PROJECT_BUTTON).click();
        return new CreateProjectPage();
    }
}
