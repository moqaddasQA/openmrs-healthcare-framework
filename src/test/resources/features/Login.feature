@Smoke @Regression
Feature: OpenMRS Login Functionality

  Scenario: Validate Login Page Loads Successfully
    Given I launch the OpenMRS application
    Then I should see the Login Page title "Login"