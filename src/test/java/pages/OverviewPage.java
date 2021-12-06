package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import wrappers.Sidebar;

@Log4j2
public class OverviewPage extends BasePage {

    @Step("Open overview page")
    public OverviewPage open() {
        log.info("Open overview page");
        projectNavigation.navigateTo("projects");
        return new OverviewPage();
    }

    @Step("Select sidebar testcase option {option}")
    public void selectSidebarOptionForTestCases(String option) {
        log.info("Select sidebar testcase option '{}'", option);
        Sidebar sidebar = new Sidebar("cases");
        sidebar.selectOption(option);
    }

    @Step("Select sidebar test run option {option}")
    public void selectSidebarOptionForTestRuns(String option) {
        log.info("Select sidebar test run option '{}'", option);
        Sidebar sidebar = new Sidebar("runs");
        sidebar.selectOption(option);
    }

    @Step("Select sidebar milestone option {option}")
    public void selectSidebarOptionForMilestones(String option) {
        log.info("Select sidebar milestone option '{}'", option);
        Sidebar sidebar = new Sidebar("milestones");
        sidebar.selectOption(option);
    }
}
