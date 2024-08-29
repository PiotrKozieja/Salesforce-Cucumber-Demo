@api @account
Feature: Adding Account using API

  Scenario Outline: Create a record for Account list using Salesforce API
    When User creates <number> Account using API
    Then Verify if GET Account has proper data
    Examples:
      | number |
      | 2      |