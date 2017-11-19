Feature: Open days in PGS Software
  As an pgs Eployee
  I want to present how tests are automated in our company using automated test
  So that I will not have to explain everything on my own

  @DniOtwartePgs
  Scenario Outline: DniOtwartePgs - technologies
    Given Google page is opened
    When Welcome message will be presented by google search
    Then Most popular ui automation tools pages can be presented

    Examples:
      | repeat |
      | true   |

  @DniOtwartePgs
  Scenario Outline: DniOtwartePgs - asta test 6 login
    Given Asta page is explained
    And Asta main page is opened
    And User navigate to regular app
    And User choose 6th exercise
    When User fill login form with data '<login>', '<password>'
    And User click 'Login' button
    Then User is properly logged in
    And User can log out

    Examples:
      | repeat | login  | password |
      | true   | tester | 123-xyz  |

  @DniOtwartePgs
  Scenario Outline: DniOtwartePgs - asta test add to basket
    Given Asta main page is opened
    And User navigate to regular app
    And User choose 7th exercise
    When User add some product '<quantity>' times to basket by drag and drop action
    Then Product will be added to basket
    And Total basket price will be calculated accordingly to products number '<quantity>'

    Examples:
      | repeat | quantity |
      | true   | 3        |

  @DniOtwartePgs
  Scenario Outline: DniOtwartePgs - asta test 8 card payment
    Given Asta main page is opened
    And User navigate to regular app
    And User choose 8th exercise
    When User fill payment form with data '<cardName>', '<firstLastName>', '<cardNumber>', '<cvv>', '<month>', '<year>'
    And User click 'Pay' button
    Then Transaction is confirmed

    Examples:
      | repeat | cardName   | firstLastName  | cardNumber       | cvv | month   | year |
      | true   | MasterCard | Tester Testowy | 5555555555554444 | 123 | October | 2020 |

  @DniOtwartePgs
  Scenario Outline: DniOtwartePgs - pgs web page
    Given Google page is opened
    When Please visit out web page info will be displayed
    Then PGS web page will be presented

    Examples:
      | repeat |
      | true   |