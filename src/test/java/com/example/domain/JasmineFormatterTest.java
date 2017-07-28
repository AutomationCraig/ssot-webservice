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

import jasmine.spec.pojos.Browsers;
import jasmine.spec.pojos.JasmineResultsWeCareAbout;
import jasmine.spec.pojos.JasmineTestCaseGeneratorFromSpecFile;

public class JasmineFormatterTest {
    
    @Test
    public void addJasmineFileToDBTest() {
    	addBuildForOurJasmineSpecResultsToSSOT();
    }
    
    public static void addBuildForOurJasmineSpecResultsToSSOT() {
    	AddDataToDBTest.setProductName("SSOT");
    	AddDataToDBTest.setProjectName("ssot-webApp");
    	AddDataToDBTest.addProduct();
    	AddDataToDBTest.addProject();
    	
    	//Now add a build from the Cucumber results file
    	File jsonFile = new File("target/jasmine/report.json");
    	String json = "";
		try {
			json = readFile(jsonFile.getAbsolutePath(), Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		}
    	Gson gson = new Gson();
    	JasmineResultsWeCareAbout result = gson.fromJson(json, JasmineResultsWeCareAbout.class);
    	List<TestCase> testListForCurrentSpec = new ArrayList<TestCase>();
    	for (Browsers browsers : result.getBrowsers()) {
    		testListForCurrentSpec = JasmineTestCaseGeneratorFromSpecFile.generate(browsers);
		}
    	AddDataToDBTest.addBuild(testListForCurrentSpec);
    }

    
    static String readFile(String path, Charset encoding) throws IOException 
	{
	  byte[] encoded = Files.readAllBytes(Paths.get(path));
	  return new String(encoded, encoding);
	}
}