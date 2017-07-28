package cuke.runner.pojos;

import java.util.List;

public class CukeResultsWeCareAbout {
	
	private String programName;
	private List<Test> tests;
	public CukeResultsWeCareAbout(String programName, List<Test> tests) {
		super();
		this.programName = programName;
		this.tests = tests;
	}
	public String getProgramName() {
		return programName;
	}
	public List<Test> getTests() {
		return tests;
	}
	


}
