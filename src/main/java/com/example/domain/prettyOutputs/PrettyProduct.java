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
	private List<PrettyProject> projects;


	public PrettyProduct(Product product) {
		super();
		this.prodcutId = product.getProdcutId();
		this.productName = product.getProductName();
		List<PrettyProject> allPrettyProjects = new ArrayList<PrettyProject>();
		if(product.getProjects() != null) {
			for (Project project : product.getProjects()) {
				PrettyProject prettyProject = new PrettyProject(project);
				allPrettyProjects.add(prettyProject);
			}
		}
		
		this.projects = allPrettyProjects;
	}


	public Long getProdcutId() {
		return prodcutId;
	}
	public String getProductName() {
		return productName;
	}
	public List<PrettyProject> getProjects() {
		return projects;
	}


	public String toString() {
		Gson gson = new Gson();
		String jsonString = gson.toJson(this);
		return jsonString;
	}
	
}
