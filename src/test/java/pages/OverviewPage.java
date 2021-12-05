package pages;

import io.qameta.allure.Step;
import wrappers.Sidebar;

public class OverviewPage extends BasePage {

    @Step("Open overview page")
    public OverviewPage open() {
        projectNavigation.navigateTo("projects");
        return new OverviewPage();
    }

    @Step("Select sidebar testcase option {option}")
    public void selectSidebarOptionForTestCases(String option) {
        Sidebar sidebar = new Sidebar("cases");
        sidebar.selectOption(option);
    }

    @Step("Select sidebar test run option {option}")
    public void selectSidebarOptionForTestRuns(String option) {
        Sidebar sidebar = new Sidebar("runs");
        sidebar.selectOption(option);
    }

    @Step("Select sidebar milestone option {option}")
    public void selectSidebarOptionForMilestones(String option) {
        Sidebar sidebar = new Sidebar("milestones");
        sidebar.selectOption(option);
    }
}
