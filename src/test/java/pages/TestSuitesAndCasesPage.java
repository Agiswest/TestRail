package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import wrappers.Input;
import wrappers.Sidebar;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class TestSuitesAndCasesPage extends BasePage {
    private final String CASE_NAME_LOCATOR = "//tr[contains(@class,'caseRow')]" +
            "/descendant::span[contains(text(),'%s')]";
    private static final String DELETE_CASE_BUTTON = ".deleteLink";
    private static final String CONFIRM_DELETE_PERMANENTLY = "(//a[contains(text(),'Delete Permanently')])[2]";
    private static final String ADD_SECTION_ID = "addSection";
    private static final String ADD_FIRST_SECTION_ID = "addSectionInline";
    private static final String SECTION_NAME_INPUT_ID = "editSectionName";
    private static final String SECTION_NAME_LOCATOR = "//span[contains(@id,'sectionName')]" +
            "[contains(text(),'%s')]";

    @Step("Open test suites and cases page")
    public TestSuitesAndCasesPage open() {
        log.info("Open test suites and cases page");
        projectNavigation.navigateTo("suites");
        return new TestSuitesAndCasesPage();
    }

    @Step("Create new case")
    public CreateCasePage addCase() {
        log.info("Create new case");
        Sidebar sidebar = new Sidebar("cases");
        sidebar.selectOption("add");
        return new CreateCasePage();
    }

    public boolean isCaseExists(String caseTitle) {
        $("span.title").shouldBe(Condition.visible);
        return $$x(String.format(CASE_NAME_LOCATOR, caseTitle)).size() != 0;
    }

    @Step("Delete case {caseName}")
    public TestSuitesAndCasesPage deleteCase(String caseName) {
        log.info("Delete case'{}'", caseName);
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions
                .moveToElement($x(String.format(CASE_NAME_LOCATOR, caseName)))
                .moveToElement($(DELETE_CASE_BUTTON))
                .click()
                .build()
                .perform();
        $x(CONFIRM_DELETE_PERMANENTLY).click();
        $x(CONFIRM_DELETE_PERMANENTLY).click();
        $x(String.format(CASE_NAME_LOCATOR, caseName)).shouldNotBe(Condition.exist);
        return new TestSuitesAndCasesPage();
    }

    @Step("Add case section {sectionName}")
    public void addCaseSection(String sectionName) {
        log.info("Add section '{}'", sectionName);
        if ($(By.id(ADD_SECTION_ID)).isDisplayed()) {
            $(By.id(ADD_SECTION_ID)).click();
        } else {
            $(By.id(ADD_FIRST_SECTION_ID)).click();
        }
        new Input(SECTION_NAME_INPUT_ID).addText(sectionName);
        $(By.id(SECTION_NAME_INPUT_ID)).submit();
        $x(String.format(SECTION_NAME_LOCATOR, sectionName)).shouldBe(Condition.visible);
    }

    public boolean isCaseSectionCreated(String sectionName) {
        return $$x(String.format(SECTION_NAME_LOCATOR, sectionName)).size() != 0;
    }
}
