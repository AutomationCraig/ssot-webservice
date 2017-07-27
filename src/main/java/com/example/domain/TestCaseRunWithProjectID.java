package com.example.domain;

import java.util.Date;

import com.example.domain.utils.RunStatus;
import com.google.gson.Gson;

/**
 * This class is for printing out pretty versions of the TestCase class
 * This will include the projectID of the TestCase (not the entire project object)
 * 			since including the entire project object would cause circular printouts
 * 			since project object includes test cases.
 * @author chrmbook
 *
 */
public class TestCaseRunWithProjectID {


	Long testCaseId = null;
	private String description;
	private RunStatus runStatus;
	private Date timestamp;
	private long projectRunID;


	
	public TestCaseRunWithProjectID(TestCaseRun testCase) {
		super();
		this.description = testCase.getDescription();
		this.runStatus = testCase.getRunStatus();
		this.timestamp = testCase.getTimestamp();
		this.projectRunID = testCase.getProjectRun().getProjectRunId();
	}

	
	public String toString() {
		Gson gson = new Gson();
		String jsonString = gson.toJson(this);
		return jsonString;
	}
}
