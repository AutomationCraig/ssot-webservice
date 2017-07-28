$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri('cucumber/features/getProducts.feature');
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
  "location": "CucumberJava.the_REST_Service_is_up()"
});
formatter.result({
  "duration": 380224427,
  "status": "passed"
});
formatter.match({
  "location": "CucumberJava.the_user_calls_the_products_end_point()"
});
formatter.result({
  "duration": 37649562,
  "status": "passed"
});
formatter.match({
  "location": "CucumberJava.they_will_get_a_list_of_all_products_in_the_database()"
});
formatter.result({
  "duration": 157668402,
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
  "location": "CucumberJava.the_REST_Service_is_up()"
});
formatter.result({
  "duration": 75790,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 64
    }
  ],
  "location": "CucumberJava.the_user_calls_the_products_end_point_passing_in_a_specific_id_(int)"
});
formatter.result({
  "duration": 38461463,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 69
    }
  ],
  "location": "CucumberJava.they_will_get_the_products_info_on_the_product_that_matches_that_id_(int)"
});
formatter.result({
  "duration": 9826619,
  "status": "passed"
});
});