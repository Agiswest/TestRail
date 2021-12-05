package pages;

import io.qameta.allure.Step;

public class TestRunsPage extends BasePage {

    @Step("Open test run page")
    public TestRunsPage open() {
        projectNavigation.navigateTo("runs");
        return new TestRunsPage();
    }

    @Step("Add test run")
    public void addRun() {
        projectNavigation.navigateTo(String.format("%s-%s", "runs", "add"));
    }

    @Step("Add test plan")
    public void addPlan() {
        projectNavigation.navigateTo(String.format("%s-%s", "plans", "add"));
    }
}
