Feature: Card Holders Filter functionality

  Background: Login
    Given User logs in to the system

  Scenario: Go to the card holder page
    Given User on the page "PayActiv : Accounts"
    And User clicks Cards menu and then select Cardholders submenu
    Then User should see the page "PayActivate"
    Then User can view the list of all cardholders

  Scenario: View cardholders by a filter for Employee
    Given User on the page "PayActiv : Accounts"
    And User clicks Cards menu and then select Cardholders submenu
    Then User should see the page "PayActivate"
    Then User can view the list of all cardholders
    When User applies a filter to search for employee names
    Then The list displays only the filtered Employees by "EmployeeName"
    When User applies a filter to search for employee id
    Then The list displays only the filtered Employees by "EmployeeId"
    When User applies a filter to search for department
    Then The list displays only the filtered Employees by "Department"
    When User applies a filter to search for Card Status
    Then The list displays only the filtered Employees by "CardStatus"
    When User applies a filter to search for Card Type
    Then The list displays only the filtered Employees by "CardType"

  Scenario: View cardholders filtered by the Employee compile filter
    Given User on the page "PayActiv : Accounts"
    And User clicks Cards menu and then select Cardholders submenu
    Then User should see the page "PayActivate"
    Then User can view the list of all cardholders
    When User applies a compile filter to search for employees
    Then The list only displays employees that have been compiled



