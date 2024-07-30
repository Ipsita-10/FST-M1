
@activity4
Feature: Login Test

  @loginTest @loginSuccessful
  Scenario: Testing Login without Examples
    Given User is on Login page
    When User enters "admin" and "password"
    Then Read the page title and verify confirmation message as "Welcome Back, admin"
    And Close the Browser
