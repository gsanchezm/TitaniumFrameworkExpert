Feature: Create user on IMDb Web Page

  Background:
    Given user must be on IMDb web application

  Scenario: Create a user
    When I click on the link "Other Sign in options"
    And I click the button "Create a New Account"
    And I Create New Account for user "TestUser"
    Then I validate "TestUser" is logged in