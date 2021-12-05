package pages;

public class MilestonesPage extends BasePage {
    private final String pageName = "milestones";

    public MilestonesPage openMilestonesPage() {
        projectNavigation.navigateTo(pageName);
        return this;
    }

    public CreateMilestonePage addMilestone() {
        projectNavigation.navigateTo(String.format("%s-%s", pageName, "add"));
        return new CreateMilestonePage();
    }
}
