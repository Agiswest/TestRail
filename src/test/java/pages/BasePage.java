package pages;

import wrappers.ProjectNavigation;

public class BasePage {
    final ProjectNavigation projectNavigation = new ProjectNavigation();

    public LoginPage logout() {
        final String userOptions = "user";
        projectNavigation.navigateTo(userOptions);
        projectNavigation.navigateTo(String.format("%s-%s", userOptions, "logout"));
        return new LoginPage();
    }

    public ProjectsPage returnToDashboardFromProject() {
        projectNavigation.navigateTo(String.format("%s-%s", "dashboard", "top"));
        return new ProjectsPage();
    }

    public ProjectsPage returnToDashboardFromAdmin() {
        projectNavigation.navigateTo("dashboard");
        return new ProjectsPage();
    }

    public AdminPage openAdminPage() {
        projectNavigation.navigateTo("admin");
        return new AdminPage();
    }


}
