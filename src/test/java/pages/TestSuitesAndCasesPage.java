package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import wrappers.Input;
import wrappers.Sidebar;

import java.util.Collection;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertFalse;

public class TestSuitesAndCasesPage extends BasePage {

    public TestSuitesAndCasesPage openPage() {
        projectNavigation.navigateTo("suites");
        return new TestSuitesAndCasesPage();
    }

    public CreateCasePage addCase() {
        Sidebar sidebar = new Sidebar("cases");
        sidebar.selectOption("add");
        return new CreateCasePage();
    }

    public TestSuitesAndCasesPage deleteCase(String caseName) {
        Collection<SelenideElement> numberOfCases = $$(".caseRow");
        assertFalse(numberOfCases.isEmpty(), "There are no test cases to delete");

        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions
                .moveToElement($x(String.format("//tr[contains(@class,'caseRow')]" +
                "/descendant::span[contains(text(),'%s')]", caseName)))
                .moveToElement($(".deleteLink"))
                .click()
                .build()
                .perform();
        $x("(//a[contains(text(),'Delete Permanently')])[2]").click();
        $x("(//a[contains(text(),'Delete Permanently')])[2]").click();
        return new TestSuitesAndCasesPage();
    }

    public void addCaseSection(String sectionName) {
        $(By.id("addSection")).click();
        new Input("editSectionName").addText(sectionName);
        $(By.id("editSectionName")).submit();
    }

    public boolean caseSectionIsCreated(String sectionName) {
        return $$x(String.format("//span[contains(@id,'sectionName')]" +
                "[contains(text(),'%s')]", sectionName)).size() != 0;
    }
}
