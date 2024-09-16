#Sample Feature Definition Template
@activity6
Feature: Login Test with DataTable

Scenario: Testing with Data from Scenario
  Given User completes the requirement
  When User enters the following username and password
    | admin     | password |
    | adminUser | Password |
    | adminUser | Password1|
  Then Verify results

Scenario: Testing the To-Do app
  Given User completes the requirement
  When User enters the following tasks
    | task1 |
    | task2 |
    | task3 |
  Then Verify results