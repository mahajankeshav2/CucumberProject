Feature: Search,Add and Place the order for Products

  @PlaceOrder
  Scenario Outline: Search Experience at Home page and Offers page
    Given User is on GreenCart Landing page
    When user searched with shortname <Name> and extract actual name of product
    And Added "3" items of selected product to cart
    Then user proceeds to Checkout and validate the <Name> items in checkout page
    And verify user has ability to enter promo code and place the order
    Examples:
    |Name|
    |Tom|
