package pages;

import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class ProjectsPage extends BasePage {
    private static final String PROJECT_LOCATOR = "//div[contains(@id,'project')]/" +
            "descendant::a[contains(text(),'%s')]";
    private static final String CREATE_NEW_PROJECT_BUTTON = "#sidebar-projects-add";

    public void openProject(String projectName) {
        $("body").sendKeys(Keys.CONTROL, Keys.END);
        $x(String.format(PROJECT_LOCATOR, projectName)).click();
    }

    public void createNewProject() {
        $(CREATE_NEW_PROJECT_BUTTON).click();
    }
}
