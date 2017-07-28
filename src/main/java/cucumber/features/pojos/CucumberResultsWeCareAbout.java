package cucumber.features.pojos;

import java.util.List;

public class CucumberResultsWeCareAbout {
	
	private List<Feature> features;
	
	
	public CucumberResultsWeCareAbout(List<Feature> features) {
		super();
		this.features = features;
	}
	
	public List<Feature> getFeatures() {
		return features;
	}


}
