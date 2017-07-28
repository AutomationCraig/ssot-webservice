package com.example.domain;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.example.domain.payload.NewBuildPayload;
import com.example.domain.utils.RunStatus;
import com.google.gson.Gson;

public class CreatingObjectsTest {

	
	public static String productName = "SSOT";
	public static String projectName = "ssot-webservice";
	public static void setProductName(String productName) {
		CreatingObjectsTest.productName = productName;
	}
	public static void setProjectName(String projectName) {
		CreatingObjectsTest.projectName = projectName;
	}




	@Test
	public void addProductProjectAndBuildToDataBaseTest() {
		addProduct();
		addProject();
		
		TestCase case1 = new TestCase("desc 11", RunStatus.PASSED, this.getClass().toString(), new Date());
		TestCase case2 = new TestCase("This is test 12", RunStatus.FAILED, this.getClass().toString(), new Date());
		TestCase case3 = new TestCase("desc 3", RunStatus.SKIPPED, this.getClass().toString(), new Date());
		TestCase case4 = new TestCase("This is test 4", RunStatus.PASSED, this.getClass().toString(), new Date());
		TestCase case5 = new TestCase("desc 5", RunStatus.FAILED, this.getClass().toString(), new Date());
		TestCase case6 = new TestCase("This is test 6", RunStatus.SKIPPED, this.getClass().toString(), new Date());
		List<TestCase> testList = Arrays.asList(case1, case2, case3, case4, case5, case6);
		addBuild(testList);
	}
	
	
	
	
	@Test
	public void createProductTest() {
		addProduct();
	}
	
	@Test
	public void createProductTest2() {
		String baseContext = "http://localhost:8080/ssot-webservice-1.0.0-SNAPSHOT/";
		String targetURL = baseContext + "rest/webService/addProduct/NextmyProductName";
		
		String JSONInput = "";
		
		String response = TestUtils.doPOST(targetURL, JSONInput);
		System.out.println("Result of Test:");
		System.out.println(response);
	}
	
	@Test
	public void createProjectTest() {
		addProject();
	}
	
	
	
	public static void addProduct() {
		String baseContext = "http://localhost:8080/ssot-webservice-1.0.0-SNAPSHOT/";
		String targetURL = baseContext + "rest/webService/addProduct/" + productName;
		
		String JSONInput = "";
		
		String response = TestUtils.doPOST(targetURL, JSONInput);
		System.out.println("Result of Product Add:");
		System.out.println(response);	
	}
	
	public static void addProject() {
		String baseContext = "http://localhost:8080/ssot-webservice-1.0.0-SNAPSHOT/";
		String targetURL = baseContext + "rest/webService/addProject/" + productName + "/" + projectName;
		
		String JSONInput = "";
		
		String response = TestUtils.doPOST(targetURL, JSONInput);
		System.out.println("Result of Project Add:");
		System.out.println(response);
	}
	
	public static void addBuild(List<TestCase> testList) {
    	String baseContext = "http://localhost:8080/ssot-webservice-1.0.0-SNAPSHOT/";
		String targetURL = baseContext + "rest/webService/addBuild";
		
		NewBuildPayload payload = new NewBuildPayload("myBuildUrl", testList, projectName);
		Gson gson = new Gson();
		String JSONInput = gson.toJson(payload);
		
		String response = TestUtils.doPOST(targetURL, JSONInput);
		System.out.println("Result of Build Add:");
		System.out.println(response);
	}

}