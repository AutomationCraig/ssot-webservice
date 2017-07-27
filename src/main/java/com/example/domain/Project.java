package com.example.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	Long id;

	@Version
	private @Column(name = "version")
	int version = 0;

	@Column
	@Expose
	private String codePath;

	@Column
	@Expose
	private String buildURL;

	@OneToMany(mappedBy="project")
	@Expose
	private List<TestCase> tests;

	
	
	public Project(String codePath, String buildURL, List<TestCase> testSuite) {
		super();
		this.codePath = codePath;
		this.buildURL = buildURL;
		this.tests = testSuite;
	}

	public Project() {
		super();
	}

	
	public List<TestCase> getTests() {
		return tests;
	}

	public void setTests(List<TestCase> tests) {
		this.tests = tests;
	}

	public Long getId() {
		return id;
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



	public String toString() {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
		String jsonString = gson.toJson(this);
		return jsonString;
	}
}