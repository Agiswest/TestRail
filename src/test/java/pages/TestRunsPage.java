package pages;

import wrappers.ProjectNavigation;

public class TestRunsPage extends BasePage {

    public TestRunsPage openTestRunsPage() {
        projectNavigation.navigateTo("runs");
        return new TestRunsPage();
    }

    public void addRun() {
        projectNavigation.navigateTo(String.format("%s-%s", "runs", "add"));
    }

    public void addPlan() {
        projectNavigation.navigateTo(String.format("%s-%s", "plans", "add"));
    }
}
