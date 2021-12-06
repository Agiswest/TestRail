package models;

import com.github.javafaker.Faker;

public class CaseFactory {

    public static Case get() {
        Faker faker = new Faker();
        String[] caseTypes = {"Acceptance", "Accessibility", "Automated",
                "Compatibility", "Destructive", "Functional",
                "Other", "Performance", "Regression",
                "Security", "Smoke & Sanity", "Usability"};
        String[] casePriorities = {"Critical", "High", "Medium", "Low"};
        return Case.builder()
                .title(faker.name().username())
                .section("Test Cases")
                .template("Test Case (Text)")
                .type(caseTypes[faker.random().nextInt(0,11)])
                .priority(casePriorities[faker.random().nextInt(0,3)])
                .estimate(faker.random().nextInt(1, 50).toString())
                .references(faker.internet().url())
                .automationType("None")
                .preconditions(faker.chuckNorris().fact())
                .steps(String.format("1. %s\n2. %s", faker.job().field(), faker.job().field()))
                .expectedResult(faker.job().keySkills())
                .build();
    }
}
