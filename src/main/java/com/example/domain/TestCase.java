package com.example.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import com.example.domain.prettyOutputs.PrettyTestCase;
import com.example.domain.utils.RunStatus;
import com.google.gson.Gson;

@Entity
public class TestCase implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, nullable = false, unique = true)
	Long testCaseId = null;

	@Version
	private @Column(name = "version")
	int version = 0;


	@Column(length=1000000)
	private String description;

	@Column
	private RunStatus runStatus;
	
	@Column
	private String location;

	@Column
	private Date timestamp;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="buildId")
	private Build build;


	
	public TestCase(String description, RunStatus runStatus, String location, Date timestamp) {
		super();
		this.description = description;
		this.runStatus = runStatus;
		this.timestamp = timestamp;
		this.location = location;
	}
	
	
	
	public TestCase() {
	}

	public Long getTestCaseId() {
		return testCaseId;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public RunStatus getRunStatus() {
		return runStatus;
	}
	public void setRunStatus(RunStatus runStatus) {
		this.runStatus = runStatus;
	}

	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public Build getBuild() {
		return build;
	}
	public void setBuild(Build project) {
		this.build = project;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	
	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (!(that instanceof TestCase)) {
			return false;
		}
		TestCase other = (TestCase) that;
		if (this.description.equals(other.description) &&
			(this.runStatus == other.runStatus) &&
			(this.timestamp.equals(other.timestamp)) &&
			(this.build.equals(other.build)) &&
			(this.location.equals(other.location))){
			return true;
		}
		return false;
	}
	
	public String toString() {
		Gson gson = new Gson();
		PrettyTestCase prettyTest = new PrettyTestCase(this);
		String jsonString = gson.toJson(prettyTest);
		return jsonString;
	}
}
