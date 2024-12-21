Feature: Card Holders functionality

  Scenario: Go to the card holder page
    Given User navigate to Login page
    When User enter valid email and password
    And User click login button
    Then User should see the page "PayActiv : Accounts"
    And User click on the card dropdown menu
    And User click on the card holder link
    Then User should see the page "PayActivate"
