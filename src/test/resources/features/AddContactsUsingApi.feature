@api
Feature: Adding contact using api
  Scenario Outline: Create a several record for contact list using Salesforce API
    When <numberOfContacts> contacts details are generated
    And New contacts with details is successfully added
    Then Check if the new contact details are correct
    Examples:
    |numberOfContacts|
    |2               |
