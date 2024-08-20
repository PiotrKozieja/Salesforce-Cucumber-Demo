@account
Feature: Check Account record creation functionality

  Scenario Outline: Create account records and verify data
    Given User is logged into the system
    And User navigates to the Accounts Page
    When User clicks on the New button
    And User creates <number> accounts with random data
    Then Verify that the data of the created accounts is correct
    Examples:
      | number |
      | 2      |