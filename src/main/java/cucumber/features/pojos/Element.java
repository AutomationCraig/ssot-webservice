package cucumber.features.pojos;

import java.util.List;

public class Element {
	String name;
	String description;
	List<Step> steps;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public List<Step> getSteps() {
		return steps;
	}
}