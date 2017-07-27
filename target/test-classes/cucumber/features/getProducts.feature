Feature: The User can get the Products list if they call the correct REST EndPoint

Scenario: Get all products
Give the REST Service is up
When the user calls the products end point
Then they will get a list of all products in the database

Scenario: Get specific products
Give the REST Service is up
When the user calls the products end point passing in a specific id <2>
Then they will get the products info on the product that matches that id <2>