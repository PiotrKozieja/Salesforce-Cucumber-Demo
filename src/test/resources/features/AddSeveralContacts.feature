#Feature: Adding several contacts
#  Scenario Outline: Create a several new record for contact list
#    Given User is logged and on Home Page
#    When User navigates to Contacts
#    Then User creates <numberOfAccounts> contacts with generated data
#    And Check if the contact details are correct
#    Examples:
#    |numberOfAccounts|
#    |2               |