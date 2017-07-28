package jasmine.spec.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.domain.TestCase;
import com.example.domain.utils.RunStatus;

public class JasmineTestCaseGeneratorFromSpecFile {
	
	
	public static List<TestCase> generate(Browsers browsers) {
		List<TestCase> allTests = new ArrayList<TestCase>();
		for (Result result : browsers.getResults()) {
			TestCase test = new TestCase();
			test.setTimestamp(new Date());
			test.setLocation("Jasmine Test Results File");
			test.setRunStatus(getStatusFromResult(result));
			test.setDescription(getDescriptionFromResult(result));
			allTests.add(test);
		}
		return allTests;
	}


	private static String getDescriptionFromResult(Result result) {
		String description = "";
		for (String describe : result.getSuite()) {
			description+= describe + " ";
		}
		description+= result.getDescription();
		return description;
	}


	public static RunStatus getStatusFromResult(Result result) {
		if(result.isSkipped()) {
			return RunStatus.SKIPPED;
		}
		if(result.isSuccess()) {
			return RunStatus.PASSED;
		}
		return RunStatus.FAILED;
	}

}
