Feature: Logout
  As a user I want to logout the app

  Scenario: Successful log out
    Given User is in the Home page
    When User clicks in the hamburguer Icon
    And Clicks in the Logout option
    Then User is redirected to the login page

