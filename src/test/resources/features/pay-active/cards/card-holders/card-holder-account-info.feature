#Feature: Card Holders Account Info functionality
#
#  Background: Login
#    Given User logs in to the system
#
#  Scenario: View Account Info with Card Type = Instant Issue & Card Status = Not Activated
#    Given User on the page "PayActiv : Accounts"
#    And User clicks Cards menu and then select Cardholders submenu
#    Then User should see the page "PayActivate"
#    Then User can view the list of all cardholders
#    When User filters cardholder with Instant Issue Card Type and Not Activated Card Status
#    And User clicks on Account Info option
#    Then The Direct Deposit Info Popup displays
#
#
#  Scenario: Admin user can view Account Info of a cardholder who has Card Type = Instant Issue & Card Status = Blocked
#    Given User on the page "PayActiv : Accounts"
#    And User clicks Cards menu and then select Cardholders submenu
#    Then User should see the page "PayActivate"
#    Then User can view the list of all cardholders
#    When User filters cardholder with Instant Issue Card Type and Blocked Card Status
#    And User clicks on Account Info option
#    Then The Direct Deposit Info Popup displays
#
#
#  Scenario: View Account Info with Card Type = Instant Issue & Card Status = Fraud Blocked
#    Given User on the page "PayActiv : Accounts"
#    And User clicks Cards menu and then select Cardholders submenu
#    Then User should see the page "PayActivate"
#    Then User can view the list of all cardholders
#    When User filters cardholder with Instant Issue Card Type and Fraud Blocked Card Status
#    And User clicks on Account Info option
#    Then The Direct Deposit Info Popup displays
#
#
#  Scenario: View Account Info with Card Type = Instant Issue & Card Status = Pending Consent
#    Given User on the page "PayActiv : Accounts"
#    And User clicks Cards menu and then select Cardholders submenu
#    Then User should see the page "PayActivate"
#    Then User can view the list of all cardholders
#    When User filters cardholder with Instant Issue Card Type and Pending Consent Card Status
#    And User clicks on Account Info option
#    Then The Direct Deposit Info Popup displays
