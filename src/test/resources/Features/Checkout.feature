Feature: Add to chart
  Scenario: User pick items and add to chart
    Given User Open browser
    And User input valid username
    And User input valid password
    And User click on login
    And User in product page
    And User click add to cart
    And User click the cart
    And User click checkout
    And User input firstname
    And User input lastname
    And User input zip code
    And User click continue
    When User click finish
    Then User checkout complete

