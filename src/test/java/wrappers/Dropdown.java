package wrappers;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class Dropdown {
    private final String label;

    public Dropdown(String label) {
        this.label = label;
    }

    public void selectOption(String option) {
        log.debug("Selecting option '{}' in dropdown '{}'", option, label);
        $x(String.format("//div[contains(@id,'%s_id_chzn')]", label)).click();
        $x(String.format("//*[@class='chzn-drop']/*/*[contains(text(),'%s')]", option)).click();
    }

    public void selectOption(String option, String customLabel) {
        log.debug("Selecting option '{}' in custom dropdown '{}_{}'", option, label, customLabel);
        $x(String.format("//div[contains(@id,'%s_%s_chzn')]", label, customLabel)).click();
        $x(String.format("//*[@class='chzn-drop']/*/*[contains(text(),'%s')]", option)).click();
    }
}
