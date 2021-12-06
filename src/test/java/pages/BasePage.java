package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import wrappers.ProjectNavigation;

@Log4j2
public class BasePage {
    final ProjectNavigation projectNavigation = new ProjectNavigation();

    @Step("Logout")
    public LoginPage logout() {
        log.info("Logout");
        final String userOptions = "user";
        projectNavigation.navigateTo(userOptions);
        projectNavigation.navigateTo(String.format("%s-%s", userOptions, "logout"));
        return new LoginPage();
    }

    @Step("Return from project to dashboard")
    public ProjectsPage returnToDashboardFromProject() {
        log.info("Return from project to dashboard");
        projectNavigation.navigateTo(String.format("%s-%s", "dashboard", "top"));
        return new ProjectsPage();
    }

    @Step("Return from administration page to dashboard")
    public ProjectsPage returnToDashboardFromAdmin() {
        log.info("Return from administration page to dashboard");
        projectNavigation.navigateTo("dashboard");
        return new ProjectsPage();
    }

    @Step("Open administration page")
    public AdminPage openAdminPage() {
        log.info("Open administration page");
        projectNavigation.navigateTo("admin");
        return new AdminPage();
    }


}
