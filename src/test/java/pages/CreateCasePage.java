package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Case;
import wrappers.Dropdown;
import wrappers.Input;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class CreateCasePage extends BasePage {

    @Step("Fill info of case")
    public TestCaseDetailsPage fillInfo(Case caseData) {
        log.info("Fill info of case by case data \"{}\"", caseData);
        new Input("title").addText(caseData.getTitle());
        new Input("estimate").addText(caseData.getEstimate());
        new Input("refs").addText(caseData.getReferences());
        new Dropdown("section").selectOption(caseData.getSection());
        new Dropdown("template").selectOption(caseData.getTemplate());
        new Dropdown("type").selectOption(caseData.getType());
        new Dropdown("priority").selectOption(caseData.getPriority());
        new Dropdown("custom_automation").selectOption(caseData.getAutomationType(), "type");
        new Input("custom_preconds_display").addText(caseData.getPreconditions());
        new Input("custom_steps_display").addText(caseData.getSteps());
        new Input("custom_expected_display").addText(caseData.getExpectedResult());
        $("#accept").click();
        return new TestCaseDetailsPage();
    }
}
