package cucumber.features.pojos;

import java.util.List;

public class Feature {
	String name;
	String keyword;
	String description;
	String uri;
	List<Element> elements;

	public String getName() {
		return name;
	}

	public String getKeyword() {
		return keyword;
	}

	public String getDescription() {
		return description;
	}

	public String getUri() {
		return uri;
	}

	public List<Element> getElements() {
		return elements;
	}
}