package pages;

public class MilestonesPage extends BasePage {
    private final String pageName = "milestones";

    public void openMilestonesPage() {
        projectNavigation.navigateTo(pageName);
    }

    public void addMilestone() {
        projectNavigation.navigateTo(String.format("%s-%s", pageName, "add"));
    }
}
