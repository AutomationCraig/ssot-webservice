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

import cucumber.features.pojos.Feature;

public class CucumberFormatterTest {
    
//    @Test
    public void tryToFormatTest() throws IOException {
    	File jsonFile = new File("target/cucumber/results.json");
    	String json = readFile(jsonFile.getAbsolutePath(), Charset.defaultCharset());
    	System.out.println(json);
    	Gson gson = new Gson();
    	Feature[] results = gson.fromJson(json, Feature[].class);
    	System.out.println("Breakpoint");
    }
    
    @Test
    public void addCucumberFileToDBTest() throws IOException {
    	CreatingObjectsTest.addProduct();
    	CreatingObjectsTest.addProject();
    	
    	//Now add a build from the Cucumber results file
    	File jsonFile = new File("target/cucumber/results.json");
    	String json = readFile(jsonFile.getAbsolutePath(), Charset.defaultCharset());
    	Gson gson = new Gson();
    	Feature[] results = gson.fromJson(json, Feature[].class);
    	List<TestCase> testList = new ArrayList<TestCase>();
    	for (Feature feature : results) {
			TestCase testToAdd = new TestCase(feature);
			testList.add(testToAdd);
		}
    	CreatingObjectsTest.addBuild(testList);
    }

    
    static String readFile(String path, Charset encoding) throws IOException 
	{
	  byte[] encoded = Files.readAllBytes(Paths.get(path));
	  return new String(encoded, encoding);
	}
}