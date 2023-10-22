Feature: Add to chart
  Scenario: User pick items and add to chart
    Given User Open browser
    And User input valid username
    And User input valid password
    And User click on login
    And User in product page
    When User click add to cart
    Then The cart is added
