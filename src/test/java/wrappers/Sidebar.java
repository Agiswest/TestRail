package wrappers;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class Sidebar {
    private final String sectionName;
    private static final String SIDEBAR_LOCATOR = "#sidebar-%s-%s";

    public Sidebar(String sectionName) {
        this.sectionName = sectionName;
    }

    public void selectOption(String option) {
        log.debug("Select sidebar option '{}' in section '{}'", option, sectionName);
        $(String.format(SIDEBAR_LOCATOR, sectionName, option)).click();
    }
}
