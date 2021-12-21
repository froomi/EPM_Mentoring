Feature: Smoke
  As a user
  I want to test all main site functional
  So that I can be sure that site works correctly

  Scenario Outline: Check login functionality
    Given User opens '<homePage>' page
    And User checks Sign-in form button visibility
    When User clicks Sign-in form button
    And User checks Email field visibility
    And User checks continue button visibility
    And User logs in using Email as '<EMAIL>'
    And User clicks continue button
    And User checks password field visibility
    And User logs in using Password as '<PASSWORD>'
    And User checks Sign-in button visibility
    And User clicks Sign-in button
    Then User checks that login is successful by seeing page


    Examples:
      | homePage                   | EMAIL               | PASSWORD        |
      | https://www.amazon.com/    | oaa9729@gmail.com   | 6nA)W2K6T       |

  Scenario Outline: Check search functionality
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User search by keyword '<KEYWORD>'
    And User clicks on first Delivery type on list
    And User checks Sort by button visibility
    And User clicks on Sort by button
    And User clicks on Price: High to Low point in list
    Then User checks that all items have pointed Delivery Type
    And User checks that items are sorted in '<ORDER>' order

    Examples:
      | homePage                | KEYWORD | ORDER |
      | https://www.amazon.com/ | gift    | desc  |


  Scenario Outline: Check name editing
    Given User opens '<homePage>' page
    And User clicks Sign-in form button
    And User logs in using Email as '<EMAIL>'
    And User clicks continue button
    And User logs in using Password as '<PASSWORD>'
    And User clicks Sign-in button
    When User clicks Sign-in form button
    And User checks Login and security form visibility
    And User clicks on Login and security form
    And User checks that Edit button in Name table is visible
    Then User clicks on Edit button
    And User clears old name and writes new one: '<NAME>'
    And User saves changes
    And User checks that message is '<MESSAGE>'


    Examples:
      | homePage                   | EMAIL               | PASSWORD        |  NAME        |   MESSAGE  |
      | https://www.amazon.com/    | oaa9729@gmail.com   | 6nA)W2K6T       |  Walter      |   Success  |


  Scenario Outline: Check Costumer Service page
    Given User opens '<homePage>' page
    And User checks Costumer Service button visibility
    When User clicks On Costumer Service button
    And User checks Help topics navigation field visibility
    And User searches solution inputting '<REQUEST>' in navigation field
    And User clicks on first result
    Then User checks that solution responds the '<REQUEST>'
    And User marks solution as helpful
    And User checks that message was marked


    Examples:
    |REQUEST| homePage                |
    | COVID | https://www.amazon.com/ |


  Scenario Outline: Check changing location entering US zip code
    Given User opens '<homePage>' page
    And User clicks Sign-in form button
    And User logs in using Email as '<EMAIL>'
    And User clicks continue button
    And User logs in using Password as '<PASSWORD>'
    And User clicks Sign-in button
    And User checks change location button visibility
    When User clicks on choose location button
    And User checks enter zip code field visibility
    And User enters '<ZIP>' in field
    And User clicks on Apply button
    And User clicks on continue button
    And User clicks on the first item in the list
    Then User checks that delivery location contains '<ZIP>' code

    Examples:
   |ZIP       | homePage                   | EMAIL               | PASSWORD        |
   |92065     | https://www.amazon.com/    | oaa9729@gmail.com   | 6nA)W2K6T       |

  Scenario Outline: Check changing language and currency
    Given User opens '<homePage>' page
    And User checks settings button visibility
    When User clicks on settings button
    And User clicks on '<LANGUAGE>' button from languages list
    And User checks currency selecting button visibility
    And User clicks on currency selecting button
    And User clicks on '<CURRENCY>' button
    And User checks save changes button visibility
    And User clicks on save changes button
    Then User checks that current url contains '<LANGUAGE>'
    And User check that current url contains '<CURRENCY>'

    Examples:
      | homePage                | LANGUAGE  | CURRENCY |
      | https://www.amazon.com/ | DE        | EUR      |
