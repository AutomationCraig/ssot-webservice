package com.example.domain;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.example.domain.payload.NewBuildPayload;
import com.example.domain.utils.RunStatus;
import com.google.gson.Gson;

public class AddDataToDBTest {


	public static String productName = "SSOT";
	public static String projectName = "ssot-webservice";
	public static void setProductName(String productName) {
		AddDataToDBTest.productName = productName;
	}
	public static void setProjectName(String projectName) {
		AddDataToDBTest.projectName = projectName;
	}


	@Test
	public void createLotsOfDataForDBTest() {
		setProductName("Open_Account");
		setProjectName("OA_Mutual_Fund");
		addProduct();
		addProject();
		TestCase case1 = new TestCase("I can successfully open a TradIRA MF Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		TestCase case2 = new TestCase("I can successfully open a RothIRA MF Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		TestCase case3 = new TestCase("I can successfully open a 529 College MF Acct", RunStatus.FAILED, this.getClass().toString(), new Date());
		TestCase case4 = new TestCase("I can successfully open a Individual MF Acct", RunStatus.SKIPPED, this.getClass().toString(), new Date());
		TestCase case5 = new TestCase("I can successfully open a Joint MF Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		List<TestCase> testList = Arrays.asList(case1, case2, case3, case4, case5);
		addBuild(testList);
		
		case1 = new TestCase("I can successfully open a TradIRA MF Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		case2 = new TestCase("I can successfully open a RothIRA MF Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		case3 = new TestCase("I can successfully open a 529 College MF Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		case4 = new TestCase("I can successfully open a Individual MF Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		case5 = new TestCase("I can successfully open a Joint MF Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		testList = Arrays.asList(case1, case2, case3, case4, case5);
		addBuild(testList);
		
		case1 = new TestCase("I can successfully open a TradIRA MF Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		case2 = new TestCase("I can successfully open a RothIRA MF Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		case4 = new TestCase("I can successfully open a Individual MF Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		case5 = new TestCase("I can successfully open a Joint MF Acct", RunStatus.SKIPPED, this.getClass().toString(), new Date());
		testList = Arrays.asList(case1, case2, case3, case4, case5);
		addBuild(testList);
		
		case1 = new TestCase("I can successfully open a TradIRA MF Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		case2 = new TestCase("I can successfully open a RothIRA MF Acct", RunStatus.FAILED, this.getClass().toString(), new Date());
		testList = Arrays.asList(case1, case2, case3, case4, case5);
		addBuild(testList);
		
		setProductName("Open_Account");
		setProjectName("OA_Brokerage");
		addProduct();
		addProject();
		case1 = new TestCase("I can successfully open a TradIRA Brokerage Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		case2 = new TestCase("I can successfully open a RothIRA Brokerage Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		case3 = new TestCase("I can successfully open a 529 College Brokerage Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		case4 = new TestCase("I can successfully open a Individual Brokerage Acct", RunStatus.SKIPPED, this.getClass().toString(), new Date());
		case5 = new TestCase("I can successfully open a Joint Brokerage Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		testList = Arrays.asList(case1, case2, case3, case4, case5);
		addBuild(testList);
		
		case1 = new TestCase("I can successfully open a TradIRA Brokerage Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		case2 = new TestCase("I can successfully open a RothIRA Brokerage Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		case3 = new TestCase("I can successfully open a 529 College Brokerage Acct", RunStatus.FAILED, this.getClass().toString(), new Date());
		case4 = new TestCase("I can successfully open a Individual Brokerage Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		case5 = new TestCase("I can successfully open a Joint Brokerage Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		testList = Arrays.asList(case1, case2, case3, case4, case5);
		addBuild(testList);

		case1 = new TestCase("I can successfully open a TradIRA Brokerage Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		case2 = new TestCase("I can successfully open a RothIRA Brokerage Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		case3 = new TestCase("I can successfully open a 529 College Brokerage Acct", RunStatus.FAILED, this.getClass().toString(), new Date());
		case4 = new TestCase("I can successfully open a Individual Brokerage Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		case5 = new TestCase("I can successfully open a Joint Brokerage Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		testList = Arrays.asList(case1, case2, case3, case4, case5);
		addBuild(testList);

		case1 = new TestCase("I can successfully open a TradIRA Brokerage Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		case2 = new TestCase("I can successfully open a RothIRA Brokerage Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		case3 = new TestCase("I can successfully open a 529 College Brokerage Acct", RunStatus.FAILED, this.getClass().toString(), new Date());
		case4 = new TestCase("I can successfully open a Individual Brokerage Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		case5 = new TestCase("I can successfully open a Joint Brokerage Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		testList = Arrays.asList(case1, case2, case3, case4, case5);
		addBuild(testList);

		case1 = new TestCase("I can successfully open a TradIRA Brokerage Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		case2 = new TestCase("I can successfully open a RothIRA Brokerage Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		case4 = new TestCase("I can successfully open a Individual Brokerage Acct", RunStatus.SKIPPED, this.getClass().toString(), new Date());
		case5 = new TestCase("I can successfully open a Joint Brokerage Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		testList = Arrays.asList(case1, case2, case3, case4, case5);
		addBuild(testList);

		case1 = new TestCase("I can successfully open a TradIRA Brokerage Acct", RunStatus.PASSED, this.getClass().toString(), new Date());
		case2 = new TestCase("I can successfully open a RothIRA Brokerage Acct", RunStatus.FAILED, this.getClass().toString(), new Date());
		testList = Arrays.asList(case1, case2, case3, case4, case5);
		addBuild(testList);
		
		
		setProductName("GEMINI");
		setProjectName("ICAP");
		addProduct();
		addProject();
		case1 = new TestCase("I can consume an Annuity file and forward it to CRD", RunStatus.PASSED, this.getClass().toString(), new Date());
		case2 = new TestCase("I can consume an Retail file and forward it to CRD", RunStatus.SKIPPED, this.getClass().toString(), new Date());
		case3 = new TestCase("I can consume an Institutional file and forward it to CRD", RunStatus.PASSED, this.getClass().toString(), new Date());
		testList = Arrays.asList(case1, case2, case3);
		addBuild(testList);
		case1 = new TestCase("I can consume an Annuity file and forward it to CRD", RunStatus.PASSED, this.getClass().toString(), new Date());
		case2 = new TestCase("I can consume an Retail file and forward it to CRD", RunStatus.SKIPPED, this.getClass().toString(), new Date());
		case3 = new TestCase("I can consume an Institutional file and forward it to CRD", RunStatus.FAILED, this.getClass().toString(), new Date());
		testList = Arrays.asList(case1, case2, case3);
		addBuild(testList);
		case1 = new TestCase("I can consume an Annuity file and forward it to CRD", RunStatus.FAILED, this.getClass().toString(), new Date());
		testList = Arrays.asList(case1, case2, case3);
		addBuild(testList);
		
		
		CucumberFormatterTest.addBuildForOurCucumberFeatureResultsToSSOT();
		CucumberFormatterTest.addBuildForOurCucumberFeatureResultsToSSOT();
		CucumberFormatterTest.addBuildForOurCucumberFeatureResultsToSSOT();
		CucumberFormatterTest.addBuildForOurCucumberFeatureResultsToSSOT();
		CucumberFormatterTest.addBuildForOurCucumberFeatureResultsToSSOT();
		JasmineFormatterTest.addBuildForOurJasmineSpecResultsToSSOT();
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
