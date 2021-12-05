package pages;

import io.qameta.allure.Step;

public class TodosPage extends BasePage {

    @Step("Open todos page")
    public void openTodosPage() {
        projectNavigation.navigateTo("todos");
    }
}
