package com.example.domain;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;

import cucumber.features.pojos.CucumberTestCaseGeneratorFromFeatureFile;
import cucumber.features.pojos.Feature;

public class CucumberFormatterTest {
    
    @Test
    public void addCucumberFileToDBTest() {
    	addBuildForOurCucumberFeatureResultsToSSOT();
    }
    
    public static void addBuildForOurCucumberFeatureResultsToSSOT() {
    	AddDataToDBTest.setProductName("SSOT");
    	AddDataToDBTest.setProjectName("ssot-webService");
    	AddDataToDBTest.addProduct();
    	AddDataToDBTest.addProject();
    	
    	//Now add a build from the Cucumber results file
    	File jsonFile = new File("target/cucumber/results.json");
    	String json = "";
		try {
			json = readFile(jsonFile.getAbsolutePath(), Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		}
    	Gson gson = new Gson();
    	Feature[] results = gson.fromJson(json, Feature[].class);
    	List<TestCase> allTestsFromAllFeatures = new ArrayList<TestCase>();
    	List<TestCase> testListForCurrentFeature = new ArrayList<TestCase>();
    	for (Feature feature : results) {
    		testListForCurrentFeature = CucumberTestCaseGeneratorFromFeatureFile.generate(feature);
    		for (TestCase testCase : testListForCurrentFeature) {
    			allTestsFromAllFeatures.add(testCase);
    		}
		}
    	AddDataToDBTest.addBuild(allTestsFromAllFeatures);
    }

    
    static String readFile(String path, Charset encoding) throws IOException 
	{
	  byte[] encoded = Files.readAllBytes(Paths.get(path));
	  return new String(encoded, encoding);
	}
}