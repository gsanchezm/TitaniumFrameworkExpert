Feature: SignIn using valid credentials

  Background:
    Given user must be on IMDb web application

  Scenario: Login into application using an existing user
    When I click on the link "Other Sign in options"
    And I click the button "Sign in with IMDb"
    Then I login with user "gilberto.aspros+001@gmail.com" and pass "Tester619"
    And I validate "Test01" is logged in
    And I Log Out from the page
