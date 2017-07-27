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

import com.google.gson.Gson;

@Path("/webService")
@Stateful
@RequestScoped
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class MyWebService {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager em;

	@GET
	@Path("/{message}")
	public String echoService(@PathParam("message") String message) {
		System.out.println("GET on message");
		return message;
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
		String allProjects = "<html><body>All projects [" + result.size() + "]:<br/>";
		if(result.size() > 0) {
			for (Project project : result) {
				System.out.println(project);
				allProjects+="<br/>" + project.toString();
			}
		}
		return  allProjects;
	}
	
	/** Returns a list of all test cases in the DB
	 * 
	 * @return
	 */
	@GET
	@Path("/AllTestCases")
	@Produces("text/xml")
	public String getAllTestCases() {
		System.out.println("GET on All Test Cases");

		TypedQuery<TestCase> query = em.createQuery("from TestCase t ",
				TestCase.class);
		List<TestCase> result = query.getResultList();
		System.out.println("There are [" + result.size() + "] tests.");
		String allTests = "<html><body>All tests [" + result.size() + "]:<br/>";
		if(result.size() > 0) {
			for (TestCase testCase : result) {
				TestCaseWithProjectID prettyTest = new TestCaseWithProjectID(testCase);
				System.out.println(prettyTest);
				allTests+="<br/>" + prettyTest.toString();
			}
		}
		return  allTests;
	}
	


	/** Creates a new Project if that project codePath does not already exist
	/* Returns a Project object, either newly created, or the one already in the
	/* system matching codePath. **/
	@POST
	@Path("/ProjectRequest/{codePath}/{buildURL}")
	@Consumes("application/json")
	public String projectPOSTRequest(@PathParam("codePath") String codePath,
			@PathParam("buildURL") String buildURL, String JsonInput) {

		Project project = new Project();
		project.setBuildURL(buildURL);
		project.setCodePath(codePath);
		ArrayList<TestCase> tests = getTestCasesFromJsonInput(JsonInput, project);
		project.setTests(tests);
		

		System.out.println("POST on a ProjectRequest for Project codePath: [" + codePath + "]");


		Project foundProject = null;
		foundProject = getProjectByCodePath(em, codePath);

		if (null == foundProject) {
			System.out.println("NEW PROJECT.");
			//Must save off Each test case, and then the new TestSuite first
			for (TestCase testCase : tests) {
				em.persist(testCase);
				em.flush();
			}
			em.persist(project);
			em.flush();
			foundProject = project;
		} else {
			System.out.println("PROJECT ALREADY EXISTED.");
		}

		return foundProject.toString();
	}// projectPOSTRequest


	private ArrayList<TestCase> getTestCasesFromJsonInput(String JsonInput, Project project) {
		Gson gson = new Gson();
		String[] testJsons = JsonInput.split(Constants.ARRAY_SPLIT_VALUE);
		ArrayList<TestCase> tests = new ArrayList<TestCase>();
		for (String test : testJsons) {
			TestCase testCase = gson.fromJson(test, TestCase.class);
			testCase.setProject(project);
			tests.add(testCase);
		}
		return tests;
	}
	
	

	/**
	 * Remove a project from the DB that has a matching codePath
	 * @param codePath
	 * @return
	 */
	@POST
	@Path("/ProjectRemovalRequest/{codePath}/")
	@Consumes("application/json")
	public String projectRemovalRequest(@PathParam("codePath") String codePath) {
		System.out
				.println("POST on a Project Removal Request for codePath: ["
						+ codePath + "]");

		Project foundProject = null;
		foundProject = getProjectByCodePath(em, codePath);

		if (null == foundProject) {
			return "No removal - No project found with codePath: "
					+ codePath;
		} else {
			em.remove(foundProject);
			em.flush();
			return "Project removed with codePath: " + codePath;
		}
	}// projectRemovalRequest


	// **************** HELPER FUNCTIONS **********************

	/** Return a Project object of the project that was removed from the DB if it matched to 1 and only 1 codePath.
	 * If no codepath match is found, or multiple matches are found, we return null.
	 * @param em
	 * @param codePath
	 * @return
	 */
	public Project getProjectByCodePath(EntityManager em, String codePath) {
		Project returnProject = null;
		try {

			TypedQuery<Project> query = em.createQuery(
					"from Project p where p.codePath = ?",
					Project.class);
			query.setParameter(1, codePath);
			List<Project> result = query.getResultList();
			if (result.isEmpty()) {
				return returnProject;
			} else {
				if (result.size() > 1) {
					System.err
							.println("ERROR: We have ["
									+ result.size()
									+ "] Projects that have the codePath of ["
									+ codePath
									+ "]. This should not happen.  Returning null");
					return returnProject;
				} else {
					// We returned 1 and only 1 User from the query
					returnProject = result.get(0);
					return returnProject;
				}
			}
		} catch (Exception e) {
			System.out
					.println("Encountered error in getProjectByCodePath function : "
							+ e);
			return returnProject;
		}
	}// getProjectByCodePath


}