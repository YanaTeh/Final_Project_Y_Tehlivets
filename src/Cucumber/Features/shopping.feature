Feature: Choose product and make order

  Scenario: Make order
    Given I am logged in with email mcwohuxvyjvkdxlcfc@cwmxc.com and password Mememe123!
    When I search for "Hummingbird Printed Sweater"
    And I click on first card
    And I choose size "M"
    And I change quantity to 5
    And I click Add to card
    And I click proceed to checkout on alert dialog
    And I click proceed to checkout on shopping card page
    And I confirm address by clicking continue button
    And I confirm Self pick up shipping method by clicking continue button
    And I choose pay by Check option
    And I agree with terms of service
    And I place order
    Then Screenshot with order confirmation is created
    And I Close browser

