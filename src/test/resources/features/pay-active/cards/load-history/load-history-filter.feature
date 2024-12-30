Feature: Load History Filter functionality

  Background: Login
    Given User logs in to the system

  Scenario: View load history by filtered criteria
    Given User on the page "PayActiv : Accounts"
    And User clicks Cards menu and then select Load History submenu
    Then User should see the page "PayActivate"
    Then User can view the list of Load History
    When User applies a filter to search for employee names in Load History
    Then The list displays only the filtered Employees in Load History by "EmployeeName"
    When User applies a filter to search for employee id in Load History
    Then The list displays only the filtered Employees in Load History by "EmployeeId"
    When User applies a filter to search for department in Load History
    Then The list displays only the filtered Employees in Load History by "Department"
    When User applies a filter to search for last 4 digits in Load History
    Then The list displays only the filtered Employees in Load History by "Last4Digits"