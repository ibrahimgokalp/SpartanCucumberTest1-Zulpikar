Feature: check data using gui, api and db


  Scenario Outline: check spartan name and gender
    Given I goto "db"
    When I provide spartan <id>
    Then "<name>" and "<gender>" should match
    Examples:
      | id  | name    | gender |
      | 107 | Mac     | Male   |
      | 119 | Jessica | Female |

  Scenario Outline: search by name
    Given I goto "db"
    When I search by "<name>"
    Then the result should equal to "<count>"
    Examples:
      | name    | count |
      | Muhtar  | 25    |
      | Jessica | 4     |

  @wip
  Scenario: partialy update a spartan
    Given I goto "api"
    When I update spartan no 107
    Then I get success message
