@login
Feature: Login feature

  Scenario: User login
    Given User is on Login Page
    When User provides username and password
    And User clicks on Login button
    Then Home Page is displayed