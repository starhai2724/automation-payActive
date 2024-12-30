Feature: Card Holders functionality

  Scenario: View list of Load History
    Given User navigate to Login page
    When User enter valid email and password
    And User click login button
    Then User should see the page "PayActiv : Accounts"
    And User click on the card dropdown menu
    And User click on the Load History link
    Then User should see the page "PayActivate"
    Then User can view the list of Load History

