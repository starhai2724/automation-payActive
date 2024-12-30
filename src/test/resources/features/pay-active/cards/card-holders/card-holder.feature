Feature: Card Holders functionality

  Scenario: Go to the card holder page
    Given User navigate to Login page
    When User enter valid email and password
    And User click login button
    Then User should see the page "PayActiv : Accounts"
    And User click on the card dropdown menu
    And User click on the Card Holder link
    Then User should see the page "PayActivate"

#  Scenario: Sort Cardholders by each column
#    Given User logs in to the system
#    And User clicks Cards menu and then select Cardholders submenu
#    #And User filters by Employee Name
#
#    When User clicks Employee header for the first time
#    Then The list is sorted in ascending order (ASC) by Employee Name
#    When User clicks Employee header for the second time
#    Then The list is sorted in descending order (DESC) by Employee Name
