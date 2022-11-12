package projects.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import projects.dao.ProjectDao;
import projects.entity.Project;

public class ProjectService {
	private ProjectDao projectDao = new ProjectDao();

	public Project addProject(Project project) {
		return projectDao.insertProject(project);
	}
	
	// calls the method from the DAO class fetchAllProducts();
	public List<Project> fetchAllProjects() {
		return projectDao.fetchAllProjects();
	}

	/* Fetches the method from ProjectDao and if no project exists for that number
	 * throws the NoSuchElementException and prints that the project does not exist.*/
	public Project fetchProjectById(Integer projectId) {
		return projectDao.fetchProjectById(projectId).orElseThrow(
		() -> new NoSuchElementException("Project with project ID=" 
			+ projectId + " does not exist."));
	}

}
