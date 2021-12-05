package pages;

import io.qameta.allure.Step;

public class MilestonesPage extends BasePage {
    private final String pageName = "milestones";

    @Step("Open milestone page")
    public MilestonesPage open() {
        projectNavigation.navigateTo(pageName);
        return this;
    }

    @Step("Create new milestone")
    public CreateMilestonePage addMilestone() {
        projectNavigation.navigateTo(String.format("%s-%s", pageName, "add"));
        return new CreateMilestonePage();
    }
}
