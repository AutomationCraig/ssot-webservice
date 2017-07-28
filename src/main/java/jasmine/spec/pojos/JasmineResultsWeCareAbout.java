package jasmine.spec.pojos;

import java.util.List;

public class JasmineResultsWeCareAbout {
	
	private List<Browsers> browsers;
	private Summary summary;
	
	public JasmineResultsWeCareAbout(List<Browsers> browsers, Summary summary) {
		super();
		this.browsers = browsers;
		this.summary = summary;
	}
	
	public List<Browsers> getBrowsers() {
		return browsers;
	}
	public Summary getSummary() {
		return summary;
	}


}
