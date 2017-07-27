package com.example.domain;

import org.junit.Test;

public class GetterTest {



	@Test
	public void getProducstTest() throws Exception {
		String targetURL = "http://localhost:8080/ssot-webservice-1.0.0-SNAPSHOT/rest/webService/products";
		String response = TestUtils.sendGet(targetURL);
		System.out.println("All PRODUCTS:");
		System.out.println(response);
		System.out.println("\n\n");
	}
	
	@Test
	public void getProjectsTest() throws Exception {
		String targetURL = "http://localhost:8080/ssot-webservice-1.0.0-SNAPSHOT/rest/webService/projects";
		String response = TestUtils.sendGet(targetURL);
		System.out.println("All PROJECTS:");
		System.out.println(response);
		System.out.println("\n\n");
	}
	
	@Test
	public void getBuildsTest() throws Exception {
		String targetURL = "http://localhost:8080/ssot-webservice-1.0.0-SNAPSHOT/rest/webService/builds";
		String response = TestUtils.sendGet(targetURL);
		System.out.println("All BUILDS:");
		System.out.println(response);
		System.out.println("\n\n");
	}
	
	@Test
	public void getTestCasesTest() throws Exception {
		String targetURL = "http://localhost:8080/ssot-webservice-1.0.0-SNAPSHOT/rest/webService/testCases";
		String response = TestUtils.sendGet(targetURL);
		System.out.println("All TEST CASES:");
		System.out.println(response);
		System.out.println("\n\n");
	}

}