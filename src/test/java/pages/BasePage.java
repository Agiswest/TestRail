package pages;

import wrappers.ProjectNavigation;

import static com.codeborne.selenide.Selenide.$x;

public class BasePage {
    final ProjectNavigation projectNavigation = new ProjectNavigation();

    public void logout() {
        final String userOptions = "user";
        projectNavigation.navigateTo(userOptions);
        projectNavigation.navigateTo(String.format("%s-%s", userOptions, "logout"));
    }

    public void returnToDashboardFromProject() {
        projectNavigation.navigateTo(String.format("%s-%s", "dashboard", "top"));
    }

    public void returnToDashboardFromAdmin() {
        projectNavigation.navigateTo("dashboard");
    }

    public void deleteProject(String projectName) {
        projectNavigation.navigateTo("admin");
        projectNavigation.navigateTo(String.format("%s-%s", "sub", "projects"));
        $x(String.format("//a[contains(text(),'%s')]" +
                "/ancestor::tr[contains(@class,'hoverSensitive')]" +
                "/descendant::div[contains(@class,'delete')]", projectName)).click();
        $x("(//*[@name='deleteCheckbox'])[3]").click();
        $x("(//*[@name='deleteCheckbox'])[3]" +
                "/ancestor::div[contains(@class,'dialog')]" +
                "/descendant::a[contains(text(),'OK')]").click();

    }
}
