Feature: Login
  As a user i want to login the app with valid credentials

  Scenario Outline: Succesful Login in Swaglabs with a valid credentials
    Given User is in the login page
    When User types a valid "<userName>"
    And Type a valid "<password>"
    And Click on the Login button
    Then The application should load the Home page

    Examples:
      | userName      | password     |
      | standard_user | secret_sauce |


