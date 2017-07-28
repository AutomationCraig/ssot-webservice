package jasmine.spec.pojos;

import java.util.List;

public class Result {

	private String description;
	private boolean skipped;
	private boolean success;
	private List<String> suite;
	
	
	public Result(String description, boolean skipped, boolean success, List<String> suite) {
		super();
		this.description = description;
		this.skipped = skipped;
		this.success = success;
		this.suite = suite;
	}
	public String getDescription() {
		return description;
	}
	public boolean isSkipped() {
		return skipped;
	}
	public boolean isSuccess() {
		return success;
	}
	public List<String> getSuite() {
		return suite;
	}
	
	
}
