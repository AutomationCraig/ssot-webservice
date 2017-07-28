package cucumber.features;
import com.example.domain.TestUtils;
import com.example.domain.payload.ProductsOutput;
import com.example.domain.payload.ProjectsOutput;
import com.example.domain.prettyOutputs.PrettyProduct;
import com.example.domain.prettyOutputs.PrettyProject;
import com.google.gson.Gson;

import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import junit.framework.Assert; 

public class CucumberStepDefs { 
	
	String restResponse;
	
	@Before
	public void setupWithAProduct() {
		String baseContext = "http://localhost:8080/ssot-webservice-1.0.0-SNAPSHOT/";
		String targetURL = baseContext + "rest/webService/addProduct/myProductName";
		String JSONInput = "";
		TestUtils.doPOST(targetURL, JSONInput);
	}
	
	@Given("^the REST Service is up$")
	public void the_REST_Service_is_up() {
		Assert.assertTrue(true);
	}
	
	@When("^the user calls the products end point$")
	public void the_user_calls_the_products_end_point() {
		String targetURL = "http://localhost:8080/ssot-webservice-1.0.0-SNAPSHOT/rest/webService/products";
		try {
			restResponse = TestUtils.sendGet(targetURL);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Then("^they will get a list of all products in the database$")
	public void they_will_get_a_list_of_all_products_in_the_database() {
	    Gson gson = new Gson();
	    ProductsOutput products = gson.fromJson(restResponse, ProductsOutput.class);
	    Assert.assertNotNull(products);
	}

	@When("^the user calls the products end point passing in a specific id <(\\d+)>$")
	public void the_user_calls_the_products_end_point_passing_in_a_specific_id_(int id) {
		String targetURL = "http://localhost:8080/ssot-webservice-1.0.0-SNAPSHOT/rest/webService/products/" + id;
		try {
			restResponse = TestUtils.sendGet(targetURL);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Then("^they will get the products info on the product that matches that id <(\\d+)>$")
	public void they_will_get_the_products_info_on_the_product_that_matches_that_id_(int id) {
	    Gson gson = new Gson();
	    PrettyProduct product = gson.fromJson(restResponse, PrettyProduct.class);
	    Assert.assertNotNull(product);
	    Assert.assertEquals(Long.valueOf(id), product.getProductId());
	}
	
	@When("^the user calls the project end point passing in a specific id <(\\d+)>$")
	public void the_user_calls_the_project_end_point_passing_in_a_specific_id_(int id) {
		String targetURL = "http://localhost:8080/ssot-webservice-1.0.0-SNAPSHOT/rest/webService/projects/" + id;
		try {
			restResponse = TestUtils.sendGet(targetURL);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Then("^they will get the build info with tests info on that project that matches that id <(\\d+)>$")
	public void they_will_get_the_build_info_with_tests_info_on_that_project_that_matches_that_id_(int id) {
	    Gson gson = new Gson();
	    PrettyProject project = gson.fromJson(restResponse, PrettyProject.class);
	    Assert.assertNotNull(project);
	    Assert.assertEquals(Long.valueOf(id), project.getProjectId());
	    Assert.assertTrue(project.getBuilds().size() > 0);
	}

	@When("^the user calls the projects end point$")
	public void the_user_calls_the_projects_end_point() {
		String targetURL = "http://localhost:8080/ssot-webservice-1.0.0-SNAPSHOT/rest/webService/projects";
		try {
			restResponse = TestUtils.sendGet(targetURL);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Then("^they will get a list of all projects in the database$")
	public void they_will_get_a_list_of_all_projects_in_the_database() {
	    Gson gson = new Gson();
	    ProjectsOutput products = gson.fromJson(restResponse, ProjectsOutput.class);
	    Assert.assertNotNull(products);
	}

	@Then("^they will get the project info on the project that matches that id <(\\d+)>$")
	public void they_will_get_the_project_info_on_the_project_that_matches_that_id_(int id) {
	    Gson gson = new Gson();
	    PrettyProject project = gson.fromJson(restResponse, PrettyProject.class);
	    Assert.assertNotNull(project);
	    Assert.assertEquals(Long.valueOf(id), project.getProjectId());
	}
}