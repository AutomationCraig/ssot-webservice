package com.example.domain.payload;

import java.util.ArrayList;
import java.util.List;

import com.example.domain.Project;
import com.example.domain.prettyOutputs.PrettyProject;

public class ProjectsOutput {
	
	private List<PrettyProject> projects;
	
	public ProjectsOutput(List<Project> projects) {
		super();
		List<PrettyProject> allPrettyProjects = new ArrayList<PrettyProject>();
		if (projects != null) {
			for (Project project : projects) {
				PrettyProject prettyProject = new PrettyProject(project);
				allPrettyProjects.add(prettyProject);
			}
		}
		
		this.projects = allPrettyProjects;
	}


	public List<PrettyProject> getProjects() {
		return projects;
	}

	
}
