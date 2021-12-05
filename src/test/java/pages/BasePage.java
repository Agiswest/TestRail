package pages;

import io.qameta.allure.Step;
import wrappers.ProjectNavigation;

public class BasePage {
    final ProjectNavigation projectNavigation = new ProjectNavigation();

    @Step("Logout")
    public LoginPage logout() {
        final String userOptions = "user";
        projectNavigation.navigateTo(userOptions);
        projectNavigation.navigateTo(String.format("%s-%s", userOptions, "logout"));
        return new LoginPage();
    }

    @Step("Return from project to dashboard")
    public ProjectsPage returnToDashboardFromProject() {
        projectNavigation.navigateTo(String.format("%s-%s", "dashboard", "top"));
        return new ProjectsPage();
    }

    @Step("Return from administration page to dashboard")
    public ProjectsPage returnToDashboardFromAdmin() {
        projectNavigation.navigateTo("dashboard");
        return new ProjectsPage();
    }

    @Step("Open administration page")
    public AdminPage openAdminPage() {
        projectNavigation.navigateTo("admin");
        return new AdminPage();
    }


}
