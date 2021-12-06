package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class Input {
    private final String labelId;

    public Input(String label) {
        this.labelId = label;
    }

    public void addText(String text) {
        log.debug("Send text '{}' to input '{}'", text, labelId);
        $(By.id(labelId)).clear();
        $(By.id(labelId)).sendKeys(text);
    }
}
