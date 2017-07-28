package com.example.domain.prettyOutputs;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.example.domain.Build;
import com.example.domain.Project;
import com.example.domain.TestCase;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

/**
 * This class is for printing out pretty versions of the TestCase class
 * This will include the projectID of the TestCase (not the entire project object)
 * 			since including the entire project object would cause circular printouts
 * 			since project object includes test cases.
 * @author chrmbook
 *
 */
public class PrettyBuild {


	private Long buildId;
	private String buildURL;
	private List<PrettyTestCase> testCases;
	private Long projectId;

	public PrettyBuild(Build build) {
		super();
		this.buildId = build.getBuildId();
		this.buildURL = build.getBuildURL();
		this.projectId = build.getProject().getProjectId();
		List<PrettyTestCase> allPrettyTestCases = new ArrayList<PrettyTestCase>();
		if(build.getTestCases() != null) {
			for (TestCase testCase : build.getTestCases()) {
				PrettyTestCase prettyTestCase = new PrettyTestCase(testCase);
				allPrettyTestCases.add(prettyTestCase);
			}
		}
		
		this.testCases = allPrettyTestCases;
	}

	public Long getBuildId() {
		return buildId;
	}
	public String getBuildURL() {
		return buildURL;
	}
	public List<PrettyTestCase> getTestCases() {
		return testCases;
	}
	public Long getProjectId() {
		return projectId;
	}



	public String toString() {
		Gson gson = new Gson();
		String jsonString = gson.toJson(this);
		return jsonString;
	}
}
