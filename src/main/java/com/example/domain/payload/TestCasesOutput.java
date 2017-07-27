package com.example.domain.payload;

import java.util.ArrayList;
import java.util.List;

import com.example.domain.TestCase;
import com.example.domain.prettyOutputs.PrettyTestCase;

public class TestCasesOutput {
	
	private List<PrettyTestCase> testCases;
	
	public TestCasesOutput(List<TestCase> testCases) {
		super();
		List<PrettyTestCase> allPrettyTests = new ArrayList<PrettyTestCase>();
		if (testCases != null) {
			for (TestCase testCase : testCases) {
				PrettyTestCase prettyTestCase = new PrettyTestCase(testCase);
				allPrettyTests.add(prettyTestCase);
			}
		}
		
		this.testCases = allPrettyTests;
	}


	public List<PrettyTestCase> getTestCases() {
		return testCases;
	}

	
}
