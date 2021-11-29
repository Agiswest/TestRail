package wrappers;

import static com.codeborne.selenide.Selenide.$;

public class Sidebar {
    private final String sectionName;
    private static final String SIDEBAR_LOCATOR = "#sidebar-%s-%s";

    public Sidebar(String sectionName) {
        this.sectionName = sectionName;
    }

    public void selectOption(String option) {
        $(String.format(SIDEBAR_LOCATOR, sectionName, option)).click();
    }
}
