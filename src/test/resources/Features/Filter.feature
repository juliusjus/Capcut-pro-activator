Feature: Add to chart
  Scenario: User can filter the items
    Given User Open browser
    And User input valid username
    And User input valid password
    And User click on login
    And User in product page
    When User click filter
    Then The page is filtered
