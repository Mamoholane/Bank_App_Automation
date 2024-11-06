Feature: Testing account

  #The are

  Background:
    Given User is on login page
    When User click customer login
    And User select customer name
    And User clicks on login button
    Then User is logged in successfully

  Scenario: Deposit is successful
    Given User is logged in successfully
    When  User select deposit
    And User enter amount
    Then User deposit successfully

  Scenario: Deposit to all accounts
    Given User is logged in successfully
    Then User deposit money to different accounts