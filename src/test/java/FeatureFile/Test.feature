@SmokeTest 
Feature: Login Page validation 
# Feature File with Gerkin Keywords
# @author Ashutosh Pradhan 

Scenario: Verify Home page should get displayed 
	Given User should on login page of the application 
	When User Enter Username and password 
	Then User Click on the login button and Verify home page should displayed 
	And User Click on the Logout Button 
	
	
	
	
	
