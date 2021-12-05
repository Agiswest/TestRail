package pages;

import io.qameta.allure.Step;

public class AdminPage extends BasePage {

    @Step("Open projects")
    public AdminProjectsPage openProjects() {
        projectNavigation.navigateTo(String.format("%s-%s", "sub", "projects"));
        return new AdminProjectsPage();
    }
}
