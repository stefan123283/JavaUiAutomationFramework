@run
Feature: Register Flow Test Suite

  Background:
    Given "/index.php?route=account/register" endpoint is accessed

  Scenario: Register Page can be accessed from the Home Page
    Given HomePage is displayed
    When registerLink from Header menu is clicked
    Then the current url contains "route=account/register" keyword

  Scenario: The Account Page URL is opened when the registration is successful
    When the register form is populated with valid random data
    And Continue button is clicked
    Then the current url contains "route=account/success" keyword

  Scenario: User remains on registerPage when the continue button is not clicked
    When the register form is populated with valid random data
    Then the current url contains "route=account/register" keyword

  @run
  Scenario Outline: An error message is displayed when invalid <impacted attribute> is used for register flow
    Given "/index.php?route=account/register" endpoint is accessed
    And the register form is populate with the following data:
      | firstName | <firstName>     |
      | lastName  | <lastName>      |
      | email     | <emailData>     |
      | password  | <passwordData>! |
    When Continue button is clicked
    Then the following list of error messages is displayed:
      | <impacted attribute> must be between 1 and 32 characters! |
    Examples:
      | impacted attribute | firstName                         | lastName                          | emailData | passwordData |
      | First Name         | 128394039489203849492930492939493 | Random                            | Random    | Random       |
      | Last Name          | Andrei                            | 128394039489203849492930492939493 | Random    | Random       |

