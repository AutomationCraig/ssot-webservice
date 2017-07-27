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

import com.example.domain.utils.RunStatus;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

@Entity
public class TestCase implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Expose
	private @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, nullable = false, unique = true)
	Long testCaseId = null;

	@Version
	private @Column(name = "version")
	int version = 0;


	@Column
	@Expose
	private String description;

	@Column
	@Expose
	private RunStatus runStatus;

	@Column
	@Expose
	private Date timestamp;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="buildId")
	private Build build;


	
	public TestCase(String description, RunStatus runStatus, Date timestamp) {
		super();
		this.description = description;
		this.runStatus = runStatus;
		this.timestamp = timestamp;
	}

	public TestCase() {
	}

	public Long getId() {
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
			(this.build.equals(other.build))){
			return true;
		}
		return false;
	}
	
	public String toString() {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
		TestCaseWithProjectID prettyTest = new TestCaseWithProjectID(this);
		String jsonString = gson.toJson(prettyTest);
		return jsonString;
	}
}
