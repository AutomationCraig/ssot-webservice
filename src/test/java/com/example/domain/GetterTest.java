package com.example.domain;

import java.util.Date;

import org.junit.Test;

import com.example.domain.utils.Constants;
import com.example.domain.utils.RunStatus;
import com.google.gson.Gson;

public class GetterTest {



	@Test
	public void getProducstTest() throws Exception {
		String targetURL = "http://localhost:8080/ssot-webservice-1.0.0-SNAPSHOT/rest/webService/AllProducts";
		String response = TestUtils.sendGet(targetURL);
		System.out.println("All PRODUCTS:");
		System.out.println(response);
		System.out.println("\n\n");
	}
	
	@Test
	public void getProjectsTest() throws Exception {
		String targetURL = "http://localhost:8080/ssot-webservice-1.0.0-SNAPSHOT/rest/webService/AllProjects";
		String response = TestUtils.sendGet(targetURL);
		System.out.println("All PROJECTS:");
		System.out.println(response);
		System.out.println("\n\n");
	}
	
	@Test
	public void getProjectRunsTest() throws Exception {
		String targetURL = "http://localhost:8080/ssot-webservice-1.0.0-SNAPSHOT/rest/webService/AllProjectRuns";
		String response = TestUtils.sendGet(targetURL);
		System.out.println("All PROJECT RUNS:");
		System.out.println(response);
		System.out.println("\n\n");
	}
	
	@Test
	public void getTestCaseRunsTest() throws Exception {
		String targetURL = "http://localhost:8080/ssot-webservice-1.0.0-SNAPSHOT/rest/webService/AllTestCaseRuns";
		String response = TestUtils.sendGet(targetURL);
		System.out.println("All TEST CASE RUNS:");
		System.out.println(response);
		System.out.println("\n\n");
	}

}