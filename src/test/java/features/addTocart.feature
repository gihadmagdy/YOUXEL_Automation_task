Feature: add item to cart
  Scenario: validate search field
    Given user navigate to home page
    And user accept cookies
    And user enter search value
      |samsung s24 ultra|
    And user click search button
    And user add item to cart
    And user click on cart button in the top right of screen
    Then validate that user navigated to cart page
    Then validate that the price add right in checkout
    And user click checkout button
    And user enter his data to login
    Then user can choose payment method
    #################its fail because website protection aganist robots#######################

