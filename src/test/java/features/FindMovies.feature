Feature: Find movies on IMDb

  Background:
    Given user must be on IMDb web application

  Scenario Outline: Find a list of movies
    When I type "<movie>"
    And I click on the link "<movie>"
    Then I validate the "<movie>" appears
    Examples:
      | movie                              |
      | Avengers: Age of Ultron            |
      | Batman v Superman: Dawn of Justice |
      | The Flash                          |
      | Iron Man                           |