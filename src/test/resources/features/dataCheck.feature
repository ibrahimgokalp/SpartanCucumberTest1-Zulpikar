Feature: check data using gui, api and db


  Scenario Outline: check spartan name and gender
    Given I goto "db"
    When I provide spartan <id>
    Then "<name>" and "<gender>" should match
    Examples:
      | id  | name    | gender |
      | 107 | Mac     | Male   |
      | 119 | Jessica | Female |

  @wip
  Scenario Outline: search by name
    Given I goto "db"
    When I search by "<name>"
    Then the result should equal to "<count>"
    Examples:
      | name    | count |
      | Muhtar  | 25    |
      | Jessica | 4     |
