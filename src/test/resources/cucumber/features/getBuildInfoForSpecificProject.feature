Feature: The User can get the Build and tests info for a specific project if they call the correct REST EndPoint

Scenario: Get all build info for specific project
Given the REST Service is up
When the user calls the project end point passing in a specific id <2>
Then they will get the build info with tests info on that project that matches that id <2>