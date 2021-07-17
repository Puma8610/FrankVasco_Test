Feature: Add products to the Shopping Cart
  As a user I wants to add products to the Shopping cart

  Background
    Given User is in the login page
    When User types a valid 'standard_user'
    And Type a valid 'secret_sauce'
    And Click on the Login button
    Then The application should load the Home page

  Scenario: Add ONE product to the Shopping Cart
    Given The user is in the Home page
    When Add to cart one product
    And Access to the shopping cart page
    Then The product selected should be added to the shopping cart correctly