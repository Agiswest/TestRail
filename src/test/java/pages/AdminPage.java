package pages;

public class AdminPage extends BasePage {

    public AdminProjectsPage openProjects() {
        projectNavigation.navigateTo(String.format("%s-%s", "sub", "projects"));
        return new AdminProjectsPage();
    }
}
