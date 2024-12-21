Feature: Login functionality

  Scenario: Successful login
    Given User navigate to Login page
    When User enter valid email and password
    And User click login button
    Then User should see the page "PayActiv : Accounts"
