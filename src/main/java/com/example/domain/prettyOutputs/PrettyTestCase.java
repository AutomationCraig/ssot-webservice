package com.example.domain.prettyOutputs;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.domain.TestCase;
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
public class PrettyTestCase {


	private Long testCaseId;
	private String description;
	private RunStatus runStatus;
	private String location;
	private Date timestamp;
	private long buildId;


	
	public PrettyTestCase(TestCase testCase) {
		super();
		this.testCaseId = testCase.getTestCaseId();
		this.description = testCase.getDescription();
		this.runStatus = testCase.getRunStatus();
		this.timestamp = testCase.getTimestamp();
		this.location = testCase.getLocation();
		this.buildId = testCase.getBuild().getBuildId();
	}

	
	public Long getTestCaseId() {
		return testCaseId;
	}
	public String getDescription() {
		return description;
	}
	public RunStatus getRunStatus() {
		return runStatus;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public long getBuildId() {
		return buildId;
	}
	public String getLocation() {
		return location;
	}


	public String toString() {
		Gson gson = new Gson();
		String jsonString = gson.toJson(this);
		return jsonString;
	}
}
