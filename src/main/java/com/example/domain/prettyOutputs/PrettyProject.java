package com.example.domain.prettyOutputs;

import java.util.ArrayList;
import java.util.List;

import com.example.domain.Build;
import com.example.domain.Project;
import com.google.gson.Gson;

/**
 * This class is for printing out pretty versions of the TestCase class
 * This will include the projectID of the TestCase (not the entire project object)
 * 			since including the entire project object would cause circular printouts
 * 			since project object includes test cases.
 * @author chrmbook
 *
 */
public class PrettyProject {

	private Long projectId;
	private String projectName;
	private long productId;
	private List<PrettyBuild> builds;

	public PrettyProject(Project project) {
		super();
		this.projectId = project.getProjectId();
		this.projectName = project.getProjectName();
		this.productId = project.getProduct().getProdcutId();
		List<PrettyBuild> allPrettyBuilds = new ArrayList<PrettyBuild>();
		if (project.getBuilds() != null) {
			for (Build build : project.getBuilds()) {
				PrettyBuild prettyBuild = new PrettyBuild(build);
				allPrettyBuilds.add(prettyBuild);
			}
		}
		
		this.builds = allPrettyBuilds;
	}

	public Long getProjectId() {
		return projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public long getProductId() {
		return productId;
	}
	public List<PrettyBuild> getBuilds() {
		return builds;
	}

	public String toString() {
		Gson gson = new Gson();
		String jsonString = gson.toJson(this);
		return jsonString;
	}
}
