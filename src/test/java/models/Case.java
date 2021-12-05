package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Case {
    String title;
    String section;
    String template;
    String type;
    String priority;
    String estimate;
    String references;
    String automationType;
    String preconditions;
    String steps;
    String expectedResult;
}
