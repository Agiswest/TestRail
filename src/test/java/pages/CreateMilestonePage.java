package pages;

import models.Milestone;
import wrappers.Dropdown;
import wrappers.Input;

import static com.codeborne.selenide.Selenide.$;

public class CreateMilestonePage extends BasePage {

    public CreateMilestonePage fillInfo(Milestone milestone) {
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

    public CreateMilestonePage addParentMilestone(String milestoneName) {
        new Dropdown("Parent").selectOption(milestoneName);
        return this;
    }

    public MilestonesPage saveMilestone() {
        $("#accept").click();
        return new MilestonesPage();
    }
}
