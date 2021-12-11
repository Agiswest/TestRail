package adapters;

import com.google.gson.Gson;
import models.Project;
import models.ProjectResponse;

public class ProjectAdapter extends BaseAdapter {

    public Project createProject(Project project) {
        String body = post(new Gson().toJson(project), "add_project");
        return new Gson().fromJson(body, Project.class);
    }

    public void deleteProject(String projectId) {
        post("", "delete_project/" + projectId);
    }

    public Project getProject(String projectId) {
        String body = get("get_project/" + projectId);
        return new Gson().fromJson(body, Project.class);
    }

    public ProjectResponse getProjects() {
        String body = get("get_projects");
        return new Gson().fromJson(body, ProjectResponse.class);
    }
}
