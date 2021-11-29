package wrappers;

import static com.codeborne.selenide.Selenide.$;

public class ProjectNavigation {
    final String NAVIGATE_LOCATOR = "#navigation-%s";

    public void navigateTo(String page) {
        $(String.format(NAVIGATE_LOCATOR, page)).click();
    }
}
