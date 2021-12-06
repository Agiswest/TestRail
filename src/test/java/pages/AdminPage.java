package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class AdminPage extends BasePage {

    @Step("Open projects")
    public AdminProjectsPage openProjects() {
        log.info("Open projects in admin page");
        projectNavigation.navigateTo(String.format("%s-%s", "sub", "projects"));
        return new AdminProjectsPage();
    }
}
