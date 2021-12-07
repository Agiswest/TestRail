package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Milestone;
import wrappers.Dropdown;
import wrappers.Input;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class CreateMilestonePage extends BasePage {

    @Step("Fill info of milestone")
    public CreateMilestonePage fillInfo(Milestone milestone) {
        log.info("Fill info of milestone by data \"{}\"", milestone);
        new Input("name").addText(milestone.getName());
        new Input("reference").addText(milestone.getReferences());
        new Input("description_display").addText(milestone.getDescription());
        new Input("start_on").addText(milestone.getStartDate());
        new Input("due_on").addText(milestone.getEndDate());
        if (milestone.isCompleted()) {
            $("#is_completed").click();
        }
        return this;
    }

    @Step("Add parent milestone {parentMilestoneName} to milestone")
    public CreateMilestonePage addParentMilestone(String parentMilestoneName) {
        log.info("Add parent milestone '{}' to milestone", parentMilestoneName);
        new Dropdown("Parent").selectOption(parentMilestoneName);
        return this;
    }

    @Step("Save milestone")
    public MilestonesPage saveMilestone() {
        log.info("Save changes in milestone");
        $("#accept").click();
        return new MilestonesPage();
    }
}
