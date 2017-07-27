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

import com.example.domain.prettyOutputs.PrettyBuild;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

@Entity
public class Build implements java.io.Serializable {

	private static final long serialVersionUID = 7884292690096443611L;

	@Id
	private @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, nullable = false)
	Long buildId;

	@Version
	private @Column(name = "version")
	int version = 0;

	@Column
	private String codePath;

	@Column
	private String buildURL;

	@OneToMany(mappedBy="build")
	private List<TestCase> testCases;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="projectId")
	private Project project;

	
	
	public Build(String codePath, String buildURL, List<TestCase> testCases) {
		super();
		this.codePath = codePath;
		this.buildURL = buildURL;
		this.testCases = testCases;
	}

	public Build() {
		super();
	}

	
	public List<TestCase> getTestCases() {
		return testCases;
	}
	public void setTestCases(List<TestCase> testCases) {
		this.testCases = testCases;
	}

	public String getCodePath() {
		return codePath;
	}
	public void setCodePath(String codePath) {
		this.codePath = codePath;
	}

	public String getBuildURL() {
		return buildURL;
	}
	public void setBuildURL(String buildURL) {
		this.buildURL = buildURL;
	}

	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}

	public Long getBuildId() {
		return buildId;
	}

	public String toString() {
		PrettyBuild prettyBuild = new PrettyBuild(this);
		Gson gson = new Gson();
		String jsonString = gson.toJson(prettyBuild);
		return jsonString;
	}
}