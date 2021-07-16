Title – CRUD Operation Test

Project description: Create Manual test cases and write scripts to Automate tests for Regression for the "Computer database application".
Prerequisites;
    1. Selenium, Java v16, TestNG, Maven.
    2. TestNG suite location: \src\main\testng.xml
    3. By default, testNG suite will be executed in parallel with no default threads. This could be changed in testng.xml property 
    4. By default, tests will be started in Firefox browser (chrome does not like my mac*sigh*). This is provided in local root directory of the project (please leave this in here as the project will not find it otherwise when executed)
        a. Browser can be changed to Chrome if preferred. This can be changed in src/main/java/resources/data.properties - set “browser” property to chrome
Resource's location:
    5. GitRepo - https://github.com/TDGhub/CRUD-App.git
    6. Application: https://computer-database.herokuapp.com/
    7. Related files: root/files/
    8. Extent Report for test runs - file:///%yourDirectory%/ComputerDatabase/reports/index.html
        a. Where %yourDirectory% is the local directory of the project

Machine to run – Mac OS
Important!
 ⚠️ Maven is required to run regression tests from this project!
 Please ensure that Maven is installed by execution of the next command in cmd or terminal: mvn --version 
Information on how to install Maven is here

How to start test execution in IDE:
    9. To run full test suite: right click on testng.xml file > Run with testNG

How to start test execution in cmd or terminal:
    10. Open cmd or terminal
    11. Go to local root directory of the project
    12. Execute the following commands:
    13. mvn compile – to double check no errors before test run
    14. mvn test - to run the suite
