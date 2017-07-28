$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri('cucumber/features/getBuildInfoForSpecificProject.feature');
formatter.feature({
  "line": 1,
  "name": "The User can get the Build and tests info for a specific project if they call the correct REST EndPoint",
  "description": "",
  "id": "the-user-can-get-the-build-and-tests-info-for-a-specific-project-if-they-call-the-correct-rest-endpoint",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Get all build info for specific project",
  "description": "",
  "id": "the-user-can-get-the-build-and-tests-info-for-a-specific-project-if-they-call-the-correct-rest-endpoint;get-all-build-info-for-specific-project",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "the REST Service is up",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "the user calls the project end point passing in a specific id \u003c2\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "they will get the build info with tests info on that project that matches that id \u003c2\u003e",
  "keyword": "Then "
});
formatter.match({
  "location": "CucumberStepDefs.the_REST_Service_is_up()"
});
formatter.result({
  "duration": 382394510,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 63
    }
  ],
  "location": "CucumberStepDefs.the_user_calls_the_project_end_point_passing_in_a_specific_id_(int)"
});
formatter.result({
  "duration": 145424829,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 83
    }
  ],
  "location": "CucumberStepDefs.they_will_get_the_build_info_with_tests_info_on_that_project_that_matches_that_id_(int)"
});
formatter.result({
  "duration": 154273042,
  "status": "passed"
});
formatter.uri('cucumber/features/getProducts.feature');
formatter.feature({
  "line": 1,
  "name": "The User can get the Products list if they call the correct REST EndPoint",
  "description": "",
  "id": "the-user-can-get-the-products-list-if-they-call-the-correct-rest-endpoint",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Get all products",
  "description": "",
  "id": "the-user-can-get-the-products-list-if-they-call-the-correct-rest-endpoint;get-all-products",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "the REST Service is up",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "the user calls the products end point",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "they will get a list of all products in the database",
  "keyword": "Then "
});
formatter.match({
  "location": "CucumberStepDefs.the_REST_Service_is_up()"
});
formatter.result({
  "duration": 6790433,
  "status": "passed"
});
formatter.match({
  "location": "CucumberStepDefs.the_user_calls_the_products_end_point()"
});
formatter.result({
  "duration": 80607409,
  "status": "passed"
});
formatter.match({
  "location": "CucumberStepDefs.they_will_get_a_list_of_all_products_in_the_database()"
});
formatter.result({
  "duration": 8708596,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Get specific products",
  "description": "",
  "id": "the-user-can-get-the-products-list-if-they-call-the-correct-rest-endpoint;get-specific-products",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "the REST Service is up",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "the user calls the products end point passing in a specific id \u003c2\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "they will get the products info on the product that matches that id \u003c2\u003e",
  "keyword": "Then "
});
formatter.match({
  "location": "CucumberStepDefs.the_REST_Service_is_up()"
});
formatter.result({
  "duration": 63527,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 64
    }
  ],
  "location": "CucumberStepDefs.the_user_calls_the_products_end_point_passing_in_a_specific_id_(int)"
});
formatter.result({
  "duration": 47917445,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 69
    }
  ],
  "location": "CucumberStepDefs.they_will_get_the_products_info_on_the_product_that_matches_that_id_(int)"
});
formatter.result({
  "duration": 9113109,
  "error_message": "junit.framework.AssertionFailedError\n\tat junit.framework.Assert.fail(Assert.java:48)\n\tat junit.framework.Assert.assertTrue(Assert.java:20)\n\tat junit.framework.Assert.assertNotNull(Assert.java:218)\n\tat junit.framework.Assert.assertNotNull(Assert.java:211)\n\tat cucumber.features.CucumberStepDefs.they_will_get_the_products_info_on_the_product_that_matches_that_id_(CucumberStepDefs.java:65)\n\tat ✽.Then they will get the products info on the product that matches that id \u003c2\u003e(cucumber/features/getProducts.feature:11)\n",
  "status": "failed"
});
formatter.uri('cucumber/features/getProjects.feature');
formatter.feature({
  "line": 1,
  "name": "The User can get the Projects list if they call the correct REST EndPoint",
  "description": "",
  "id": "the-user-can-get-the-projects-list-if-they-call-the-correct-rest-endpoint",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Get all projects",
  "description": "",
  "id": "the-user-can-get-the-projects-list-if-they-call-the-correct-rest-endpoint;get-all-projects",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "the REST Service is up",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "the user calls the projects end point",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "they will get a list of all projects in the database",
  "keyword": "Then "
});
formatter.match({
  "location": "CucumberStepDefs.the_REST_Service_is_up()"
});
formatter.result({
  "duration": 22544808,
  "status": "passed"
});
formatter.match({
  "location": "CucumberStepDefs.the_user_calls_the_projects_end_point()"
});
formatter.result({
  "duration": 145922283,
  "status": "passed"
});
formatter.match({
  "location": "CucumberStepDefs.they_will_get_a_list_of_all_projects_in_the_database()"
});
formatter.result({
  "duration": 42197123,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Get specific project",
  "description": "",
  "id": "the-user-can-get-the-projects-list-if-they-call-the-correct-rest-endpoint;get-specific-project",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "the REST Service is up",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "the user calls the project end point passing in a specific id \u003c2\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "they will get the project info on the project that matches that id \u003c2\u003e",
  "keyword": "Then "
});
formatter.match({
  "location": "CucumberStepDefs.the_REST_Service_is_up()"
});
formatter.result({
  "duration": 64915,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 63
    }
  ],
  "location": "CucumberStepDefs.the_user_calls_the_project_end_point_passing_in_a_specific_id_(int)"
});
formatter.result({
  "duration": 129933651,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 68
    }
  ],
  "location": "CucumberStepDefs.they_will_get_the_project_info_on_the_project_that_matches_that_id_(int)"
});
formatter.result({
  "duration": 22070517,
  "status": "passed"
});
});