Feature: Add address after login

  Scenario Outline: Create and check new address
    Given I am logged in to Coderslab testlab with email mcwohuxvyjvkdxlcfc@cwmxc.com and password Mememe123!
    When I click add first address tile
    And I fill new address form with <firstname> <lastname> <address> <city> <postcode>
    And I save new address form
    Then I can see new address
    And I verify created address <firstname>, <lastname>, <address>, <city>, <postcode>
    And I delete last address
    And I close browser
    Examples:
      | firstname | lastname | address     | city   | postcode |
      | Mishel    | Malysh   | English-Tea | London | AA-888   |
