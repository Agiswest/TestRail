package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.interactions.Actions;
import wrappers.Sidebar;

import java.util.Collection;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertFalse;

public class TestSuitesAndCasesPage extends BasePage {

    public void openPage() {
        projectNavigation.navigateTo("suites");
    }

    public void addCase() {
        Sidebar sidebar = new Sidebar("cases");
        sidebar.selectOption("add");
    }

    public void deleteCase(String caseName) {
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
    }
}
