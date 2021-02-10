Feature: Validate feature
  
    Scenario: Validation of valid token
    Given User has logged in using userName "admin" and password "pass"
    And made a get call to /validate
    Then session should be validated
    And Http status code as "200" should be returned
    