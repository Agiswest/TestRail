package wrappers;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Input {
    private final String labelId;

    public Input(String label) {
        this.labelId = label;
    }

    public void addText(String text) {
        $(By.id(labelId)).clear();
        $(By.id(labelId)).sendKeys(text);
    }
}
