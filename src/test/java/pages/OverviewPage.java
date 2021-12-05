package pages;

import wrappers.Sidebar;

public class OverviewPage extends BasePage {

    public OverviewPage openPage() {
        projectNavigation.navigateTo("projects");
        return new OverviewPage();
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
}
