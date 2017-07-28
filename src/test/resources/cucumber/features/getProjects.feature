Feature: The User can get the Projects list if they call the correct REST EndPoint

Scenario: Get all projects
Given the REST Service is up
When the user calls the projects end point
Then they will get a list of all projects in the database

Scenario: Get specific project
Given the REST Service is up
When the user calls the project end point passing in a specific id <2>
Then they will get the project info on the project that matches that id <2>