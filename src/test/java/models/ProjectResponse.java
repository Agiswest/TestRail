package models;

import lombok.Data;

@Data
public class ProjectResponse {
    String size;
    Project[] projects;
}
