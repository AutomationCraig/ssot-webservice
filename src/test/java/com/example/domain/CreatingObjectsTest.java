package com.example.domain;

import java.util.Date;

import org.junit.Test;

import com.example.domain.utils.Constants;
import com.example.domain.utils.RunStatus;
import com.google.gson.Gson;

public class CreatingObjectsTest {



	@Test
	public void createProductTest() {
		String baseContext = "http://localhost:8080/ssot-webservice-1.0.0-SNAPSHOT/";
		String targetURL = baseContext + "rest/webService/ProductRequest/myProductName";
		
		String JSONInput = "";
		
		String response = TestUtils.doPOST(targetURL, JSONInput);
		System.out.println("Result of Test:");
		System.out.println(response);
	}
	
	@Test
	public void createProjectTest() {
		String baseContext = "http://localhost:8080/ssot-webservice-1.0.0-SNAPSHOT/";
		String targetURL = baseContext + "rest/webService/ProjectRequest/myProductName/myProjectName";
		
		String JSONInput = "";
		
		String response = TestUtils.doPOST(targetURL, JSONInput);
		System.out.println("Result of Test:");
		System.out.println(response);
	}
	
	@Test
	public void createProjectRunTest() {
		String baseContext = "http://localhost:8080/ssot-webservice-1.0.0-SNAPSHOT/";
		String targetURL = baseContext + "rest/webService/ProjectRunRequest/myProjectName/myCodePath/myBuildURL";
		
		TestCaseRun case1 = new TestCaseRun("desc 11", RunStatus.PASSED, new Date());
		TestCaseRun case2 = new TestCaseRun("This is test 12", RunStatus.FAILED, new Date());
		TestCaseRun case3 = new TestCaseRun("desc 3", RunStatus.SKIPPED, new Date());
		TestCaseRun case4 = new TestCaseRun("This is test 4", RunStatus.PASSED, new Date());
		TestCaseRun case5 = new TestCaseRun("desc 5", RunStatus.FAILED, new Date());
		TestCaseRun case6 = new TestCaseRun("This is test 6", RunStatus.SKIPPED, new Date());
		Gson gson = new Gson();
		String JSONInput = gson.toJson(case1) + Constants.ARRAY_SPLIT_VALUE + gson.toJson(case2)
		 	+ Constants.ARRAY_SPLIT_VALUE+ gson.toJson(case3) + Constants.ARRAY_SPLIT_VALUE + gson.toJson(case4)
		 	+ Constants.ARRAY_SPLIT_VALUE + gson.toJson(case5) + Constants.ARRAY_SPLIT_VALUE + gson.toJson(case6);
		
		String response = TestUtils.doPOST(targetURL, JSONInput);
		System.out.println("Result of Test:");
		System.out.println(response);
	}

}