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
public class ProjectRun implements java.io.Serializable {

	private static final long serialVersionUID = 7884292690096443611L;

	@Id
	@Expose
	private @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, nullable = false)
	Long projectRunId;

	@Version
	private @Column(name = "version")
	int version = 0;

	@Column
	@Expose
	private String codePath;

	@Column
	@Expose
	private String buildURL;

	@OneToMany(mappedBy="projectRun")
	@Expose
	private List<TestCaseRun> testCaseRuns;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="projectId")
	private Project project;

	
	
	public ProjectRun(String codePath, String buildURL, List<TestCaseRun> testCaseRuns) {
		super();
		this.codePath = codePath;
		this.buildURL = buildURL;
		this.testCaseRuns = testCaseRuns;
	}

	public ProjectRun() {
		super();
	}

	
	public List<TestCaseRun> getTestCaseRuns() {
		return testCaseRuns;
	}
	public void setTestCaseRuns(List<TestCaseRun> testCaseRuns) {
		this.testCaseRuns = testCaseRuns;
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

	public Long getProjectRunId() {
		return projectRunId;
	}

	public String toString() {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
		String jsonString = gson.toJson(this);
		return jsonString;
	}
}