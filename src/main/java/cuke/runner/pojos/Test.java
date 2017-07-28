package cuke.runner.pojos;

public class Test {

	String description;
	String status;
	public Test(String description, String status) {
		super();
		this.description = description;
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public String getStatus() {
		return status;
	}
	
	
}
