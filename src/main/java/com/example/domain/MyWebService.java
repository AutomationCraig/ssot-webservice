package com.example.domain;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.example.domain.utils.Constants;
import com.example.domain.utils.DBSearch;
import com.google.gson.Gson;

@Path("/webService")
@Stateful
@RequestScoped
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class MyWebService {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager em;
	
	private DBSearch dbSearch = new DBSearch();

//	@GET
//	@Path("/{message}")
//	public String echoService(@PathParam("message") String message) {
//		System.out.println("GET on message");
//		return message;
//	}

	/** Returns a list of all products in the DB
	 * 
	 * @return
	 */
	@GET
	@Path("/AllProducts")
	@Produces("text/xml")
	public String getAllProducts() {
		System.out.println("GET on All Products");

		TypedQuery<Product> query = em.createQuery("from Product p ",
				Product.class);
		List<Product> result = query.getResultList();
		System.out.println("There are [" + result.size() + "] products.");
		String allProjects = "<html><body>All products [" + result.size() + "]:<br/>";
		if(result.size() > 0) {
			for (Product product : result) {
				System.out.println(product);
				allProjects+="<br/>" + product.toString();
			}
		}
		return  allProjects;
	}

	/** Returns a list of all projects in the DB
	 * 
	 * @return
	 */
	@GET
	@Path("/AllProjects")
	@Produces("text/xml")
	public String getAllProjects() {
		System.out.println("GET on All Projects");

		TypedQuery<Project> query = em.createQuery("from Project p ",
				Project.class);
		List<Project> result = query.getResultList();
		System.out.println("There are [" + result.size() + "] projects.");
		String allProjects = "<html><body>All project [" + result.size() + "]:<br/>";
		if(result.size() > 0) {
			for (Project project : result) {
				System.out.println(project);
				allProjects+="<br/>" + project.toString();
			}
		}
		return  allProjects;
	}
	
	/** Returns a list of all project Runs in the DB
	 * 
	 * @return
	 */
	@GET
	@Path("/AllProjectRuns")
	@Produces("text/xml")
	public String getAllProjectRuns() {
		System.out.println("GET on All ProjectRuns");

		TypedQuery<ProjectRun> query = em.createQuery("from ProjectRun p ",
				ProjectRun.class);
		List<ProjectRun> result = query.getResultList();
		System.out.println("There are [" + result.size() + "] projectRuns.");
		String allProjects = "<html><body>All projectRuns [" + result.size() + "]:<br/>";
		if(result.size() > 0) {
			for (ProjectRun projectRun : result) {
				System.out.println(projectRun);
				allProjects+="<br/>" + projectRun.toString();
			}
		}
		return  allProjects;
	}
	
	/** Returns a list of all test cases in the DB
	 * 
	 * @return
	 */
	@GET
	@Path("/AllTestCaseRuns")
	@Produces("text/xml")
	public String getAllTestCaseRuns() {
		System.out.println("GET on All Test Case Runs");

		TypedQuery<TestCaseRun> query = em.createQuery("from TestCaseRun t ",
				TestCaseRun.class);
		List<TestCaseRun> result = query.getResultList();
		System.out.println("There are [" + result.size() + "] tests.");
		String allTests = "<html><body>All tests [" + result.size() + "]:<br/>";
		if(result.size() > 0) {
			for (TestCaseRun testCase : result) {
				TestCaseRunWithProjectID prettyTest = new TestCaseRunWithProjectID(testCase);
				System.out.println(prettyTest);
				allTests+="<br/>" + prettyTest.toString();
			}
		}
		return  allTests;
	}
	
	
	
	
	
	
	
	
	
	/** Creates a new Product if that product name does not already exist
	/* Returns a Product object, either newly created, or the one already in the
	/* system matching name. **/
	@POST
	@Path("/ProductRequest/{name}")
	@Consumes("application/json")
	public String productPOSTRequest(@PathParam("name") String name) {

		Product product  = new Product();
		product.setProductName(name);

		System.out.println("POST on a Product for name: [" + name + "]");


		Product foundProduct = null;
		foundProduct = dbSearch.getProductByName(em, name);

		if (null == foundProduct) {
			System.out.println("NEW PRODUCT.");
			em.persist(product);
			em.flush();
			foundProduct = product;
		} else {
			System.out.println("PRODUCT ALREADY EXISTED.");
		}

		return foundProduct.toString();
	}// productPOSTRequest
	
	/** Creates a new Project if that product name does not already exist
	/* Returns a Project object, either newly created, or the one already in the
	/* system matching name. **/
	@POST
	@Path("/ProjectRequest/{productName}/{projectName}")
	@Consumes("application/json")
	public String projectPOSTRequest(@PathParam("productName") String productName, @PathParam("projectName") String projectName) {

		Product product = dbSearch.getProductByName(em, productName);
		if(product == null) {
			System.out.println("We can't add a Project if the Product doesn't exist");
			return "We can't add a Project if the Product doesn't exist";
		}
		
		Project project  = new Project();
		project.setProjectName(projectName);
		project.setProduct(product);

		System.out.println("POST on a Project for name: [" + projectName + "]");


		Project foundProject = null;
		foundProject = dbSearch.getProjectByName(em, projectName);

		if (null == foundProject) {
			System.out.println("NEW PROJECT.");
			em.persist(project);
			em.flush();
			foundProject = project;
		} else {
			System.out.println("PROJECT ALREADY EXISTED.");
		}

		return foundProject.toString();
	}// projectPOSTRequest


	/** Creates a new Project if that project projectName does not already exist
	/* Returns a Project object, either newly created, or the one already in the
	/* system matching projectName. **/
	@POST
	@Path("/ProjectRunRequest/{projectName}/{codePath}/{buildURL}")
	@Consumes("application/json")
	public String projectRunPOSTRequest(@PathParam("projectName") String projectName, @PathParam("codePath") String codePath,
			@PathParam("buildURL") String buildURL, String JsonInput) {

		Project project = dbSearch.getProjectByName(em, projectName);
		if(project == null) {
			System.out.println("We can't add a project Run if the project doesn't exist");
			return "We can't add a project Run if the project doesn't exist";
		}
		
		ProjectRun projectRun  = new ProjectRun();
		projectRun.setProject(project);
		projectRun.setBuildURL(buildURL);
		projectRun.setCodePath(codePath);
		ArrayList<TestCaseRun> tests = getTestCasesFromJsonInput(JsonInput, projectRun);
		projectRun.setTestCaseRuns(tests);
		

		System.out.println("POST on a ProjecRuntRequest for projectName: [" + projectName + "]");
		System.out.println("NEW PROJECT RUN.");
		
		//Must save off Each test case, and then the new TestSuite first
		for (TestCaseRun testCase : tests) {
			em.persist(testCase);
			em.flush();
		}
		em.persist(projectRun);
		em.flush();

		return projectRun.toString();
	}// projectRunPOSTRequest


	private ArrayList<TestCaseRun> getTestCasesFromJsonInput(String JsonInput, ProjectRun project) {
		Gson gson = new Gson();
		String[] testJsons = JsonInput.split(Constants.ARRAY_SPLIT_VALUE);
		ArrayList<TestCaseRun> tests = new ArrayList<TestCaseRun>();
		for (String test : testJsons) {
			TestCaseRun testCase = gson.fromJson(test, TestCaseRun.class);
			testCase.setProjectRun(project);
			tests.add(testCase);
		}
		return tests;
	}
	
	

//	/**
//	 * Remove a project from the DB that has a matching codePath
//	 * @param codePath
//	 * @return
//	 */
//	@POST
//	@Path("/ProjectRemovalRequest/{codePath}/")
//	@Consumes("application/json")
//	public String projectRemovalRequest(@PathParam("codePath") String codePath) {
//		System.out
//				.println("POST on a Project Removal Request for codePath: ["
//						+ codePath + "]");
//
//		ProjectRun foundProject = null;
//		foundProject = getProjecRuntByCodePath(em, codePath);
//
//		if (null == foundProject) {
//			return "No removal - No project found with codePath: "
//					+ codePath;
//		} else {
//			em.remove(foundProject);
//			em.flush();
//			return "Project removed with codePath: " + codePath;
//		}
//	}// projectRemovalRequest


	// **************** HELPER FUNCTIONS **********************




}