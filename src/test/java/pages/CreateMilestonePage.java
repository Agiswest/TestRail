package pages;

import models.Milestone;

import static com.codeborne.selenide.Selenide.$;

public class CreateMilestonePage extends BasePage {

    public void fillInfo(Milestone milestone) {
        $("#name").sendKeys(milestone.getName());
        $("#reference").sendKeys(milestone.getReferences());
        $("#description_display").sendKeys(milestone.getDescription());
        $("#start_on").sendKeys(milestone.getStartDate());
        $("#due_on").sendKeys(milestone.getEndDate());
        if (milestone.isCompleted()) {
            $("#is_completed").click();
        }
        $("#accept").click();
    }

    public void addParentMilestone(String milestoneName) {
        $(".dropdown-size").click();
        $("div[class$=search]>input").sendKeys(milestoneName);
        $(".group-option[id^=parent_id]").click();
    }
}
