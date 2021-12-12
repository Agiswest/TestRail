package wrappers;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class Dropdown {
    private final String label;
    private static final String DROPDOWN_LOCATOR = "//div[contains(@id,'%s_id_chzn')]";
    private static final String CUSTOM_DROPDOWN_LOCATOR = "//div[contains(@id,'%s_%s_chzn')]";
    private final String DROPDOWN_OPTIONS_LOCATOR = "//*[@class='chzn-drop']/*/*[contains(text(),'%s')]";

    public Dropdown(String label) {
        this.label = label;
    }

    public void selectOption(String option) {
        log.debug("Selecting option '{}' in dropdown '{}'", option, label);
        $x(String.format(DROPDOWN_LOCATOR, label)).click();
        $x(String.format(DROPDOWN_OPTIONS_LOCATOR, option)).click();
    }

    public void selectOption(String option, String customLabel) {
        log.debug("Selecting option '{}' in custom dropdown '{}_{}'", option, label, customLabel);
        $x(String.format(CUSTOM_DROPDOWN_LOCATOR, label, customLabel)).click();
        $x(String.format(DROPDOWN_OPTIONS_LOCATOR, option)).click();
    }
}
