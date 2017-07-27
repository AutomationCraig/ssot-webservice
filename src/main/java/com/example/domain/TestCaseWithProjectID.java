package com.example.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.domain.utils.RunStatus;
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
public class TestCaseWithProjectID {


	private String description;
	private RunStatus runStatus;
	private Date timestamp;
	private long buildId;


	
	public TestCaseWithProjectID(TestCase testCase) {
		super();
		this.description = testCase.getDescription();
		this.runStatus = testCase.getRunStatus();
		this.timestamp = testCase.getTimestamp();
		this.buildId = testCase.getBuild().getBuildId();
	}

	
	public String toString() {
		Gson gson = new Gson();
		String jsonString = gson.toJson(this);
		return jsonString;
	}
}
