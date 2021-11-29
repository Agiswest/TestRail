package pages;

import wrappers.Sidebar;

import static com.codeborne.selenide.Selenide.$;

public class OverviewPage extends BasePage {

    public void openPage() {
        projectNavigation.navigateTo("projects");
    }

    public void selectSidebarOptionForTestCases(String option) {
        Sidebar sidebar = new Sidebar("cases");
        sidebar.selectOption(option);
    }

    public void selectSidebarOptionForTestRuns(String option) {
        Sidebar sidebar = new Sidebar("runs");
        sidebar.selectOption(option);
    }

    public void selectSidebarOptionForMilestones(String option) {
        Sidebar sidebar = new Sidebar("milestones");
        sidebar.selectOption(option);
    }

    public void editProject() {
        $(".button-edit").click();
    }
}
