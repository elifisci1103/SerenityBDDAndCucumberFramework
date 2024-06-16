Feature: User Management API Tests
Background:
  Given User sets the base API URL to "https://reqres.in"

  @api
  Scenario: User should not be able to log in with invalid credentials
    Given API user sets "/api/users" path parameters
    When User sends a login request with "invalidUsername" and "invalidPassword"
    Then User should receive a login failure response

 @api
  Scenario:User should be able to update their information
    Given API user sets "/api/users/2" path parameters
    And User updates "name" and "job" information
    And Verifies that the job title is "tester"



