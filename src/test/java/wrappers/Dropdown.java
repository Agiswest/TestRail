package wrappers;

import static com.codeborne.selenide.Selenide.$x;

public class Dropdown {
    private final String label;

    public Dropdown(String label) {
        this.label = label;
    }

    public void selectOption(String option) {
        $x(String.format("//div[contains(@id,'%s_id_chzn')]", label)).click();
        $x(String.format("//*[@class='chzn-drop']/*/*[contains(text(),'%s')]", option)).click();
    }

    public void selectOption(String option, String customLabel) {
        $x(String.format("//div[contains(@id,'%s_%s_chzn')]", label, customLabel)).click();
        $x(String.format("//*[@class='chzn-drop']/*/*[contains(text(),'%s')]", option)).click();
    }
}
