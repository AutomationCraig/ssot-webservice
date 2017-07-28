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

import com.example.domain.payload.BuildsOutput;
import com.example.domain.payload.NewBuildPayload;
import com.example.domain.payload.ProductsOutput;
import com.example.domain.payload.ProjectsOutput;
import com.example.domain.payload.TestCasesOutput;
import com.example.domain.prettyOutputs.PrettyProduct;
import com.example.domain.prettyOutputs.PrettyProject;
import com.example.domain.prettyOutputs.PrettyTestCase;
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
	@Path("/products")
	@Produces("application/json")
	public String getAllProducts() {
		System.out.println("GET on All Products");

		TypedQuery<Product> query = em.createQuery("from Product p ",
				Product.class);
		List<Product> result = query.getResultList();
		System.out.println("There are [" + result.size() + "] products.");

		ProductsOutput output = new ProductsOutput(result);
		Gson gson = new Gson();
		return gson.toJson(output);
	}
	
	/** Returns a list of all projects in the DB
	 * 
	 * @return
	 */
	@GET
	@Path("/products/{product_id}")
	@Produces("application/json")
	public String getSpecificProduct(@PathParam("product_id") long productId) {
		System.out.println("GET on specific Projects by id");

		Product foundProduct = dbSearch.getProductByID(em, productId);
		if (foundProduct == null) {
			return "";
		}
		System.out.println("we are using product id : " + foundProduct.toString());
		
		Gson gson = new Gson();
		return gson.toJson(new PrettyProduct(foundProduct));
	}

	/** Returns a list of all projects in the DB
	 * 
	 * @return
	 */
	@GET
	@Path("/projects")
	@Produces("application/json")
	public String getAllProjects() {
		System.out.println("GET on All Projects");

		TypedQuery<Project> query = em.createQuery("from Project p ",
				Project.class);
		List<Project> result = query.getResultList();
		System.out.println("There are [" + result.size() + "] projects.");

		ProjectsOutput output = new ProjectsOutput(result);
		Gson gson = new Gson();
		return gson.toJson(output);
	}
	
	/** Returns a list of all projects in the DB
	 * 
	 * @return
	 */
	@GET
	@Path("/projects/{project_id}")
	@Produces("application/json")
	public String getSpecificProject(@PathParam("project_id") long projectId) {
		System.out.println("GET on specific Projects by id");

		Project foundProject = dbSearch.getProjectByID(em, projectId);
		if (foundProject == null) return "";
		
		System.out.println("we are using project id : " + foundProject.toString());
		
		Gson gson = new Gson();
		return gson.toJson(new PrettyProject(foundProject));
	}
	
	/** Returns a list of all project Runs in the DB
	 * 
	 * @return
	 */
	@GET
	@Path("/builds")
	@Produces("application/json")
	public String getAllBuilds() {
		System.out.println("GET on All Builds");

		TypedQuery<Build> query = em.createQuery("from Build b ",
				Build.class);
		List<Build> result = query.getResultList();
		System.out.println("There are [" + result.size() + "] builds.");

		BuildsOutput output = new BuildsOutput(result);
		Gson gson = new Gson();
		return gson.toJson(output);
	}
	
	/** Returns a list of all test cases in the DB
	 * 
	 * @return
	 */
	@GET
	@Path("/testCases")
	@Produces("application/json")
	public String getAllTestCaseRuns() {
		System.out.println("GET on All Test Cases");

		TypedQuery<TestCase> query = em.createQuery("from TestCase t ",
				TestCase.class);
		List<TestCase> result = query.getResultList();
		System.out.println("There are [" + result.size() + "] tests.");
		
		TestCasesOutput output = new TestCasesOutput(result);
		Gson gson = new Gson();
		return gson.toJson(output);
	}
	
	
	
	
	
	
	
	
	
	/** Creates a new Product if that product name does not already exist
	/* Returns a Product object, either newly created, or the one already in the
	/* system matching name. **/
	@POST
	@Path("/addProduct/{name}")
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
	}// addProduct
	
	/** Creates a new Project if that product name does not already exist
	/* Returns a Project object, either newly created, or the one already in the
	/* system matching name. **/
	@POST
	@Path("/addProject/{productName}/{projectName}")
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
	}// addProject


	/** Creates a new Project if that project projectName does not already exist
	/* Returns a Project object, either newly created, or the one already in the
	/* system matching projectName. **/
	@POST
	@Path("/addBuild")
	@Consumes("application/json")
	public String buildPOSTRequest(String JsonInput) {

		Gson gson = new Gson();
		NewBuildPayload payload = gson.fromJson(JsonInput, NewBuildPayload.class);
		
		Project project = dbSearch.getProjectByName(em, payload.getProjectName());
		if(project == null) {
			System.out.println("We can't add a project Run if the project doesn't exist");
			return "We can't add a project Run if the project doesn't exist";
		}
		
		Build build  = new Build();
		build.setProject(project);
		build.setBuildURL(payload.getBuildURL());
		build.setTestCases(payload.getTestCases());
		

		System.out.println("POST on a BuildRequest for projectName: [" + project.getProjectName() + "]");
		System.out.println("NEW BUILD.");
		
		//Must save off Each test case, and then the new TestSuite first
		for (TestCase testCase : payload.getTestCases()) {
			testCase.setBuild(build);
			em.persist(testCase);
			em.flush();
		}
		em.persist(build);
		em.flush();

		return build.toString();
	}// addBuild


	

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