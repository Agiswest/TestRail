package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class MilestonesPage extends BasePage {
    private final String pageName = "milestones";

    @Step("Open milestone page")
    public MilestonesPage open() {
        log.info("Open milestone page");
        projectNavigation.navigateTo(pageName);
        return this;
    }

    @Step("Create new milestone")
    public CreateMilestonePage addMilestone() {
        log.info("Create new milestone");
        projectNavigation.navigateTo(String.format("%s-%s", pageName, "add"));
        return new CreateMilestonePage();
    }
}
