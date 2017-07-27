package com.example.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.example.domain.prettyOutputs.PrettyProject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

@Entity
public class Project implements java.io.Serializable {

	private static final long serialVersionUID = 7884292690096443611L;

	@Id
	private @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, nullable = false)
	Long projectId;

	@Version
	private @Column(name = "version")
	int version = 0;

	@Column
	private String projectName;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="prodcutId")
	private Product product;
	
	@OneToMany(mappedBy="project")
	private List<Build> builds;

	
	
	public Project(String projectName) {
		super();
		this.projectName = projectName;
	}

	public Project() {
		super();
	}

	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public List<Build> getBuilds() {
		return builds;
	}
	public void setBuilds(List<Build> projectRuns) {
		this.builds = projectRuns;
	}

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getProjectId() {
		return projectId;
	}

	public String toString() {
		PrettyProject prettyProject = new PrettyProject(this);
		Gson gson = new Gson();
		return gson.toJson(prettyProject);
	}
}