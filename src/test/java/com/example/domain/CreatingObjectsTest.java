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
	public void addProductProjectAndBuildToDataBaseTest() {
		AddDataToDBTest.addProduct();
		AddDataToDBTest.addProject();
		
		TestCase case1 = new TestCase("desc 11", RunStatus.PASSED, this.getClass().toString(), new Date());
		TestCase case2 = new TestCase("This is test 12", RunStatus.FAILED, this.getClass().toString(), new Date());
		TestCase case3 = new TestCase("desc 3", RunStatus.SKIPPED, this.getClass().toString(), new Date());
		TestCase case4 = new TestCase("This is test 4", RunStatus.PASSED, this.getClass().toString(), new Date());
		TestCase case5 = new TestCase("desc 5", RunStatus.FAILED, this.getClass().toString(), new Date());
		TestCase case6 = new TestCase("This is test 6", RunStatus.SKIPPED, this.getClass().toString(), new Date());
		List<TestCase> testList = Arrays.asList(case1, case2, case3, case4, case5, case6);
		AddDataToDBTest.addBuild(testList);
	}
	
	
	
	
	@Test
	public void createProductTest() {
		AddDataToDBTest.addProduct();
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
		AddDataToDBTest.addProject();
	}
	
	

}