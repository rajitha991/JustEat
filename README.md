# JustEat
Maven project implemented to test search restaurants functionality in JustEat.uk using TestNG.

Important Points:
1. All configuration file is placed in "config.properties" file which is available in src\main\java\com\ConfigFiles\config.properties
2. config.properties contain the url and browser type.
3. This script is capable to execute in Chrome and Firefox Browser.
4. Please execute this program from testng.xml [Right click on testng.xml and run as TestNG Suite.
5. Browser exe driver files are available in resources folder.

***************************Working of Program**************************
Scenario 1: Search retuarant result display when searched with Postal Code "AR51 1AA"
Scenario 2: Verify the error message displayed when invalid Postal Code is entered
Scenario 3: Verify the search result sort functionality based on distance after changing the Location once

*******************************Steps to Execute************************
Install Java and Eclipse IDE
Import the project from Git
Install Maven and set the environment variables
To run from maven provide below commands in command prompt at project location:
mvn test-compile
mvn test
OR Update the Maven dependencies
Execute the test cases from testng.xml file

************************************About project and Structure********************************************************
	1. src/main/java : contains all main functions
	PACKAGES, Class and Functions
		1.1 com.BaseClass: This package contains class files for browser launch and configuration.
			BaseClass.java: contains methods to initialize browser and Property file
		
		1.2 com.ConfigFiles: This package contains configuration files
			config.properties: contains environment variables like URL and browser.
		1.3 com.pages: contains class according to Website pages.
			LandingPage.java: contains all element related to Landing Page and Methods to perform action on LandingPage.
			SearchResultPage.java: contains all element related to Search Result Page and Methods to perform action on the Page.

	2.resource: Contains browser exe files
	3.src/test/java: contains classes to test Search Resturant functionality.
		3.1 com.Test: This package contains the TestNG classes to perform the test
			SearchResturantTest.java : contains test methods to test the application.
			
	 
		
