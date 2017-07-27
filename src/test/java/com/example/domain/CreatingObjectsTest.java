package com.example.domain;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.example.domain.payload.NewBuildPayload;
import com.example.domain.utils.RunStatus;
import com.google.gson.Gson;

public class CreatingObjectsTest {



	@Test
	public void createProductTest() {
		String baseContext = "http://localhost:8080/ssot-webservice-1.0.0-SNAPSHOT/";
		String targetURL = baseContext + "rest/webService/addProduct/myProductName";
		
		String JSONInput = "";
		
		String response = TestUtils.doPOST(targetURL, JSONInput);
		System.out.println("Result of Test:");
		System.out.println(response);
	}
	
	@Test
	public void createProjectTest() {
		String baseContext = "http://localhost:8080/ssot-webservice-1.0.0-SNAPSHOT/";
		String targetURL = baseContext + "rest/webService/addProject/myProductName/myProjectName";
		
		String JSONInput = "";
		
		String response = TestUtils.doPOST(targetURL, JSONInput);
		System.out.println("Result of Test:");
		System.out.println(response);
	}
	
	@Test
	public void createBuildTest() {
		String baseContext = "http://localhost:8080/ssot-webservice-1.0.0-SNAPSHOT/";
		String targetURL = baseContext + "rest/webService/addBuild";
		
		TestCase case1 = new TestCase("desc 11", RunStatus.PASSED, new Date());
		TestCase case2 = new TestCase("This is test 12", RunStatus.FAILED, new Date());
		TestCase case3 = new TestCase("desc 3", RunStatus.SKIPPED, new Date());
		TestCase case4 = new TestCase("This is test 4", RunStatus.PASSED, new Date());
		TestCase case5 = new TestCase("desc 5", RunStatus.FAILED, new Date());
		TestCase case6 = new TestCase("This is test 6", RunStatus.SKIPPED, new Date());
		List<TestCase> testList = Arrays.asList(case1, case2, case3, case4, case5, case6);
		
		NewBuildPayload payload = new NewBuildPayload("myCodePath", "myBuildUrl", testList, "myProjectName");
		Gson gson = new Gson();
		String JSONInput = gson.toJson(payload);
		
		String response = TestUtils.doPOST(targetURL, JSONInput);
		System.out.println("Result of Test:");
		System.out.println(response);
	}

}