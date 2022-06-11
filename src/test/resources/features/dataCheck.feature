Feature: check data using gui, api and db


  @wip
  Scenario Outline: check spartan name and gender
    Given I goto webpage
    When I provide spartan <id>
    Then "<name>" and "<gender>" should match
    Examples:
      | id  | name    | gender |
      | 107 | Mac     | Male   |
      | 119 | Jessica | Female |