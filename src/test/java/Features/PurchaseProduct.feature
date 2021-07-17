Feature: Purchase a product
  As a user I wants to purchase a products from Swaglabs

  Background
    Given User is in the login page
    When User types a valid user name 'standard_user'
    And Type a valid password 'secret_sauce'
    And Click on the Login button
    Then The application should load the Home page

  Scenario: Purchase ONE product
    Given The user has added to the shopping cart One product
    When The user checkouts the purchase
    And The user fills "<firstName>", "<lastName>" and "<ZipCode>"
    Then The product selected should be the one added to the cart
    And The user user finishes the purchase
    And The application should load the thank you message
