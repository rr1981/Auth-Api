
Feature: login feature
  It should login the user

  Scenario: User enters valid credentials
    Given User has entered userName "admin" and password "pass"
    And made a post call for "/login"
    Then User should get a valid auth token
    
  Scenario: User enters invalid credentials
    Given User has entered userName "adm" and password "pas"
    And made a post call for "/login" with wrong details
    Then User should get an exception
