Feature: Log in to saucedemo.com
  Scenario Outline: Login to application as valid user
    Given User Open browser
    And User Open Website Saucedemo
    When User input <username> username
    And User input <password> password
    And User click on login
    Then User verify <status> result

Examples:
  | username      | password     | status  |  |
  | standard_user | secret_sauce | success |  |
  | abcdefg       | 13245        | failed  |  |