package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class MilestonesPage extends BasePage {
    private final String MILESTONES_PAGE = "milestones";

    @Step("Open milestone page")
    public MilestonesPage open() {
        log.info("Open milestone page");
        projectNavigation.navigateTo(MILESTONES_PAGE);
        return this;
    }

    @Step("Create new milestone")
    public CreateMilestonePage addMilestone() {
        log.info("Create new milestone");
        projectNavigation.navigateTo(String.format("%s-%s", MILESTONES_PAGE, "add"));
        return new CreateMilestonePage();
    }

    public String getSuccessMessage() {
        return $(".message-success").getText();
    }
}
