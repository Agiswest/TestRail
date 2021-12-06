package wrappers;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class ProjectNavigation {
    final String NAVIGATE_LOCATOR = "#navigation-%s";

    public void navigateTo(String page) {
        log.debug("Navigate to page '{}'", page);
        $(String.format(NAVIGATE_LOCATOR, page)).click();
    }
}
