Feature: Testing account


  Scenario Outline: Failing scenario
    Given User is on login screen
    When  User enter Email "<Email>"
    And User enter Password "<Password>"
    And User click on login button
    Then User is logged in successfully

    Examples:
      | Email | Password |
      | 1500  | sssssss  |
