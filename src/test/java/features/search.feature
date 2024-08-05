Feature: search feature
  Scenario: validate search field
    Given user navigate to home page
    And user accept cookies
    And user enter search value
    |samsung s24 ultra|
    And user click search button
    And user click sort list
    And user select sort type
    Then validate sortion type

    Scenario: validate product filtering
      Given user navigate to home page
      And user accept cookies
      And user click on mobile and tablets from side menu
      And user click on desired mobile brand
      Then validate that mobile brand shown
      And user click on screen size filter
      Then validate that mobile filtered
