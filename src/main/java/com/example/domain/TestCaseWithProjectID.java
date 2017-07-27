package com.example.domain;

import java.util.Date;

import com.google.gson.Gson;

/**
 * This class is for printing out pretty versions of the TestCase class
 * This will include the projectID of the TestCase (not the entire project object)
 * 			since including the entire project object would cause circular printouts
 * 			since project object includes test cases.
 * @author chrmbook
 *
 */
public class TestCaseWithProjectID {


	Long testCaseId = null;
	private String description;
	private boolean isPassingStatus;
	private Date timestamp;
	private long projectID;


	
	public TestCaseWithProjectID(TestCase testCase) {
		super();
		this.description = testCase.getDescription();
		this.isPassingStatus = testCase.isPassingStatus();
		this.timestamp = testCase.getTimestamp();
		this.projectID = testCase.getProject().getId();
	}

	
	public String toString() {
		Gson gson = new Gson();
		String jsonString = gson.toJson(this);
		return jsonString;
	}
}
