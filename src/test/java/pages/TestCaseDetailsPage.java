package pages;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class TestCaseDetailsPage extends BasePage {
    private static final String MESSAGE_LOCATOR = "//div[contains(@class,'message-success')]" +
            "[normalize-space(.)]";

    public String getConfirmationMessage() {
        log.info("Get confirmation message");
        return $x(MESSAGE_LOCATOR).getText();
    }
}
