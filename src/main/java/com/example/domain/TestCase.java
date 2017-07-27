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
	private boolean isPassingStatus;

	@Column
	@Expose
	private Date timestamp;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	private Project project;


	
	public TestCase(String description, boolean isPassingStatus, Date timestamp) {
		super();
		this.description = description;
		this.isPassingStatus = isPassingStatus;
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

	public boolean isPassingStatus() {
		return isPassingStatus;
	}
	public void setPassingStatus(boolean isPassingStatus) {
		this.isPassingStatus = isPassingStatus;
	}

	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
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
			(this.isPassingStatus == other.isPassingStatus) &&
			(this.timestamp.equals(other.timestamp)) &&
			(this.project.equals(other.project))){
			return true;
		}
		return false;
	}
	
	public String toString() {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
		String jsonString = gson.toJson(this);
		return jsonString;
	}
}
