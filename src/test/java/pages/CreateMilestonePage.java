package pages;

import models.Milestone;
import wrappers.Dropdown;
import wrappers.Input;

import static com.codeborne.selenide.Selenide.$;

public class CreateMilestonePage extends BasePage {

    public void fillInfo(Milestone milestone) {
        new Input("name").addText(milestone.getName());
        new Input("reference").addText(milestone.getReferences());
        new Input("description_display").addText(milestone.getDescription());
        new Input("start_on").addText(milestone.getStartDate());
        new Input("due_on").addText(milestone.getEndDate());
        if (milestone.isCompleted()) {
            $("#is_completed").click();
        }
    }

    public void addParentMilestone(String milestoneName) {
        new Dropdown("Parent").selectOption(milestoneName);
    }

    public void saveMilestone() {
        $("#accept").click();
    }
}
