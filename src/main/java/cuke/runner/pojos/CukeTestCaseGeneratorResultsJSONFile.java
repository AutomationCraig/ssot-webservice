package cuke.runner.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.domain.TestCase;
import com.example.domain.utils.RunStatus;

public class CukeTestCaseGeneratorResultsJSONFile {
	
	
	public static List<TestCase> generate(CukeResultsWeCareAbout results) {
		List<TestCase> allTests = new ArrayList<TestCase>();
		for (Test test : results.getTests()) {
			TestCase testCase = new TestCase();
			testCase.setTimestamp(new Date());
			testCase.setLocation("CUKE Test File");
			testCase.setRunStatus(test.getStatus().equals("passed") ? RunStatus.PASSED : RunStatus.FAILED);
			testCase.setDescription(test.getDescription());
			allTests.add(testCase);
		}
		return allTests;
	}


}
