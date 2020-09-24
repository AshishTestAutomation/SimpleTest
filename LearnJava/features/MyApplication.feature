Feature: Test Facebook smoke scenarios

  @tag1
  Scenario: Test Login with Valid Credentials
    Given Open FF and Launch URL
    When I entered "test@testmail.com" and "test123"
    Then User should be able to login successfully