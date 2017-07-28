package com.example.domain.payload;

import java.util.List;

import com.example.domain.TestCase;

public class NewBuildPayload {
	
	private String buildURL;
	private List<TestCase> testCases;
	private String projectName;
	
	public NewBuildPayload(String buildURL, List<TestCase> testCases, String projectName) {
		super();
		this.buildURL = buildURL;
		this.testCases = testCases;
		this.projectName = projectName;
	}


	public String getBuildURL() {
		return buildURL;
	}

	public List<TestCase> getTestCases() {
		return testCases;
	}

	public String getProjectName() {
		return projectName;
	}
	
	
}
