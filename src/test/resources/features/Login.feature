@Smoke @Regression
Feature: OpenMRS Login Functionality

  Scenario: scenario: Validate Login Page Loads Successfully (Final Pipeline Verification)
    Given I launch the OpenMRS application
    Then I should see the Login Page title "Login"

  Scenario: Unsuccessful Login with Invalid Credentials
    Given I launch the OpenMRS application
    When I enter username "WrongUser"
    And I enter password "WrongPassword"
    And I click the login button
    Then I should see the error message "Invalid username/password. Please try again."

  Scenario Outline: Unsuccessful Login with Invalid Credentials
    Given I launch the OpenMRS application
    When I enter username "<username>"
    And I enter password "<password>"
    And I click the login button
    Then I should see the error message "Invalid username/password. Please try again."

    Examples:
      | username    | password    |
      | WrongUser   | WrongPass   |
      | Admin       | BadPass123  |
      | doctor      | Admin123    |