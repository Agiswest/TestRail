package models;

import com.github.javafaker.Faker;

import java.util.Random;

public class ProjectFactory {

    public static Project get() {
        Faker faker = new Faker();
        String[] suiteMode = {"single", "single_baseline", "multi"};
        return Project.builder()
                .name(faker.name().fullName())
                .announcement(faker.backToTheFuture().quote())
                .showAnnouncement(new Random().nextBoolean())
                .suiteMode(suiteMode[0])
                .build();
    }
}
