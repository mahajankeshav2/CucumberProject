
Feature: Search and Place the order for Products

  @SearchProduct
 Scenario Outline: Search Experience at Home page and Offers page
    Given User is on GreenCart Landing page
    When user searched with shortname <Name> and extract actual name of product
    Then user searched for <Name> shortname in offers page
    And validate product name in offers page match with landing page
   Examples:
   |Name|
   |Tom|
   |Beet|