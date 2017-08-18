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

import cuke.runner.pojos.CukeResultsWeCareAbout;
import cuke.runner.pojos.CukeTestCaseGeneratorResultsJSONFile;

public class CuteFormatterTest {
    
    @Test
    public void addCuteFileToDBTest() {
    	addBuildForOurJasmineSpecResultsToSSOT();
    }
    
    public static void addBuildForOurJasmineSpecResultsToSSOT() {
    	AddDataToDBTest.setProductName("SSOT");
    	AddDataToDBTest.setProjectName("ssot-cute-database");
    	AddDataToDBTest.addProduct();
    	AddDataToDBTest.addProject();
    	
    	//Now add a build from the Cucumber results file
    	File jsonFile = new File("target/cute/cute_results.json");
    	String json = "";
		try {
			json = readFile(jsonFile.getAbsolutePath(), Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		}
    	Gson gson = new Gson();
    	CukeResultsWeCareAbout result = gson.fromJson(json, CukeResultsWeCareAbout.class);
    	List<TestCase> testListForCurrentCute = new ArrayList<TestCase>();
    	testListForCurrentCute = CukeTestCaseGeneratorResultsJSONFile.generate(result);
    	AddDataToDBTest.addBuild(testListForCurrentCute);
    }

    
    static String readFile(String path, Charset encoding) throws IOException 
	{
	  byte[] encoded = Files.readAllBytes(Paths.get(path));
	  return new String(encoded, encoding);
	}
}