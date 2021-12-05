package pages;

import static com.codeborne.selenide.Selenide.*;

public class AdminProjectsPage extends BasePage {

    public AdminProjectsPage deleteProject(String projectName) {
        $x(String.format("//a[contains(text(),'%s')]" +
                "/ancestor::tr[contains(@class,'hoverSensitive')]" +
                "/descendant::div[contains(@class,'delete')]", projectName)).click();
        $x("(//*[@name='deleteCheckbox'])[3]").click();
        $x("(//*[@name='deleteCheckbox'])[3]" +
                "/ancestor::div[contains(@class,'dialog')]" +
                "/descendant::a[contains(text(),'OK')]").click();
        return this;
    }

    public void editProjectName(String projectName, String newProjectName) {
        $x(String.format("//a[contains(text(),'%s')]", projectName)).click();
        new CreateProjectPage().editProjectName(newProjectName);
    }

    public String getSuccessMessage() {
        return $(".message-success").getText();
    }

    public boolean projectExists(String projectName) {
        return $$x(String.format("//tr[contains(@class,'hoverSensitive')]" +
                "//a[contains(text(),'%s')][normalize-space(.)]", projectName)).size() != 0;
    }
}
