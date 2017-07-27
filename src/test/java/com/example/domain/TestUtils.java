package com.example.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import com.google.gson.Gson;

public class TestUtils {

	public static String doGET(String URLstring) {
		try {
			String returnVal = "";

			URL url = new URL(URLstring);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				returnVal = "Failed : HTTP error code : "
						+ conn.getResponseCode();
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			while ((output = br.readLine()) != null) {
				returnVal += output;
			}

			conn.disconnect();
			return returnVal;

		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String doPOST(String URLstring, String JSONInput) {
		try {
			String returnVal = "";

			URL url = new URL(URLstring);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			OutputStreamWriter wr = new OutputStreamWriter(
					conn.getOutputStream());
			wr.write(JSONInput);
			wr.flush();

			// Get the response
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				returnVal += line;
			}
			wr.close();
			rd.close();
			return returnVal;

		} catch (MalformedURLException e) {
			e.printStackTrace();
			return "printStackTrace error: " + e;
		} catch (IOException e) {
			e.printStackTrace();
			return "IOException error: " + e;
		}
	}

	@Test
	public void createProject() {
		String baseContext = "http://localhost:8080/ssot-webservice-1.0.0-SNAPSHOT/";
		String targetURL = baseContext + "rest/webService/ProjectRequest/project_2/jenkinsBuildURL_2";
		
		TestCase case1 = new TestCase("desc 11", true, new Date());
		TestCase case2 = new TestCase("This is test 12", false, new Date());
		TestCase case3 = new TestCase("desc 3", true, new Date());
		TestCase case4 = new TestCase("This is test 4", false, new Date());
		TestCase case5 = new TestCase("desc 5", true, new Date());
		TestCase case6 = new TestCase("This is test 6", false, new Date());
		Gson gson = new Gson();
		String JSONInput = gson.toJson(case1) + Constants.ARRAY_SPLIT_VALUE + gson.toJson(case2)
		 	+ Constants.ARRAY_SPLIT_VALUE+ gson.toJson(case3) + Constants.ARRAY_SPLIT_VALUE + gson.toJson(case4)
		 	+ Constants.ARRAY_SPLIT_VALUE + gson.toJson(case5) + Constants.ARRAY_SPLIT_VALUE + gson.toJson(case6);
		
		String response = doPOST(targetURL, JSONInput);
		System.out.println("END OF TEST");
		System.out.println(response);
	}

	public static TestCase getUser(URL baseContext, long facebookID) {
		String targetURL = baseContext
				+ "rest/webService/User/" + facebookID;
		String response = doGET(targetURL);

		Gson gsonUser = new Gson();
		TestCase responseUser = gsonUser.fromJson(response, TestCase.class);

		return responseUser;
	}

	public static Project getPlayer(URL baseContext, long facebookID) {
		String targetURL = baseContext
				+ "rest/webService/Player/" + facebookID;
		String response = doGET(targetURL);

		Gson gsonPlayer = new Gson();
		Project responsePlayer = gsonPlayer.fromJson(response, Project.class);

		return responsePlayer;
	}

	public static String removePlayer(URL baseContext, long facebookID) {
		String targetURL = baseContext
				+ "rest/webService/PlayerRemovalRequest/" + facebookID;
		String JSONInput = "";
		String response = doPOST(targetURL, JSONInput);

		return response;
	}
}