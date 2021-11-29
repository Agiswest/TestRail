package wrappers;

import static com.codeborne.selenide.Selenide.$;

public class Input {
    private final String labelCss;

    public Input(String label) {
        this.labelCss = label;
    }

    public void addText(String text) {
        $(String.format("#%s", labelCss)).sendKeys(text);
    }
}
