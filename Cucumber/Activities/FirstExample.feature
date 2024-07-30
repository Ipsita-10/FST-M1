@FirstExample
Feature: Basic Syntax
	
	@FirstScenario @SmokeTest
	Scenario: Basic test for Selenium
		Given the user is on TS homepage
		When the user clicks on the about us link
		Then the user is redirected to the about page
	