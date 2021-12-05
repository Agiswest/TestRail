package pages;

import io.qameta.allure.Step;
import models.Case;

import static com.codeborne.selenide.Selenide.$$x;

public class TestCaseDetailsPage extends BasePage {

    @Step("Validate case data")
    public boolean dataOfCaseIsValid(Case caseData) {
        final String dataLocator = "//*[contains(text(),\"%s\")]";
        final String[] caseDataMass = {caseData.getTitle(), caseData.getType(), caseData.getPriority(),
                caseData.getEstimate(), caseData.getTemplate(), caseData.getSteps(), caseData.getSection(),
                caseData.getReferences(), caseData.getPreconditions(), caseData.getExpectedResult(),
                caseData.getAutomationType()};
        boolean caseDataIsValid = true;
        for (String a : caseDataMass) {
            if ($$x(String.format(dataLocator, a)).size() == 0) {
             caseDataIsValid = false;
            }
        }
        return caseDataIsValid;
    }
}
