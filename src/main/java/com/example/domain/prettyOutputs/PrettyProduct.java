package com.example.domain.prettyOutputs;

import java.util.ArrayList;
import java.util.List;

import com.example.domain.Product;
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
public class PrettyProduct {

	private Long prodcutId;
	private String productName;
	private List<ProjectProperties> projectProperties;



	public PrettyProduct(Product product) {
		super();
		this.prodcutId = product.getProdcutId();
		this.productName = product.getProductName();
		List<ProjectProperties> allProjectProperties = new ArrayList<ProjectProperties>();
		if(product.getProjects() != null) {
			for (Project project : product.getProjects()) {
				ProjectProperties projectProperties = new ProjectProperties(project.getProjectName(), project.getProjectId());
				allProjectProperties.add(projectProperties);
			}
		}
		this.projectProperties = allProjectProperties;
	}


	public Long getProdcutId() {
		return prodcutId;
	}
	public String getProductName() {
		return productName;
	}
	public List<ProjectProperties> getProjectProperties() {
		return projectProperties;
	}


	public String toString() {
		Gson gson = new Gson();
		String jsonString = gson.toJson(this);
		return jsonString;
	}
	
	
	
	public class ProjectProperties {
		private String projectName;
		private Long projectId;
		public ProjectProperties(String projectName, Long projectId) {
			super();
			this.projectName = projectName;
			this.projectId = projectId;
		}
	}
	
}
