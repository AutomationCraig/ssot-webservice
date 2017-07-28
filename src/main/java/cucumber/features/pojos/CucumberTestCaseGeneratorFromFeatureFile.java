package cucumber.features.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import com.example.domain.TestCase;
import com.example.domain.utils.RunStatus;

@Entity
public class CucumberTestCaseGeneratorFromFeatureFile {
	
	private static final String STATUS_TO_CHECK_FOR_FAILED = "failed";
	
	public static List<TestCase> generate(Feature feature) {
		List<TestCase> allTests = new ArrayList<TestCase>();
		for ( Element element : feature.getElements()) {
			TestCase test = new TestCase();
			String description = element.getName();
			for (Step step : element.getSteps()) {
				description += "<p/>" + step.getKeyword() + step.getName();
			}
			test.setTimestamp(new Date());
			test.setLocation(feature.getUri());
			test.setRunStatus(areAllStatusesPassing(element));
			test.setDescription(description);
			allTests.add(test);
		}
		return allTests;
	}


	public static RunStatus areAllStatusesPassing(Element element) {
		for (Step step : element.getSteps()) {
			if(step.getResult().getStatus().equals(STATUS_TO_CHECK_FOR_FAILED)) {
				return RunStatus.FAILED;
			}
		}
		return RunStatus.PASSED;
	}

}
