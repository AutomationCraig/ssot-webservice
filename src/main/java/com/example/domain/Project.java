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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

@Entity
public class Project implements java.io.Serializable {

	private static final long serialVersionUID = 7884292690096443611L;

	@Id
	@Expose
	private @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, nullable = false)
	Long projectId;

	@Version
	private @Column(name = "version")
	int version = 0;

	@Column
	@Expose
	private String projectName;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="prodcutId")
	private Product product;
	
	@OneToMany(mappedBy="project")
	@Expose
	private List<Build> projectRuns;

	
	
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
	
	public List<Build> getProjectRuns() {
		return projectRuns;
	}
	public void setProjectRuns(List<Build> projectRuns) {
		this.projectRuns = projectRuns;
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
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
		String jsonString = gson.toJson(this);
		return jsonString;
	}
}