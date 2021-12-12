package models;

import com.github.javafaker.Faker;

import java.util.Random;

public class MilestoneFactory {

    public static Milestone get() {
        Faker faker = new Faker();
        return Milestone.builder()
                .name(faker.job().title())
                .references(faker.internet().url())
                .description(faker.harryPotter().quote())
                .startDate(getRandomDate())
                .endDate(getRandomDate())
                .isCompleted(false)
                .build();
    }

    private static String getRandomDate() {
        Random random = new Random();
        final String dateFormat = "%d/%d/%d";
        final int randomMonth = random.nextInt(11) + 1;
        final int randomDay = random.nextInt(27) + 1;
        final int randomYear = random.nextInt(5) + 2020;
        return String.format(dateFormat, randomMonth, randomDay, randomYear);
    }
}
