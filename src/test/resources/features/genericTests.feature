Feature: User is able to run tests

  Background:
    Given I am on the homepage

  @Test @NavigationBar
  Scenario Outline: User navigates to different page using navigation bar
    When I select the "<pageLink>" link from the navigation bar
    Then I should be taken to the "<pageTitle>" page

    Examples:
      | pageLink   | pageTitle  |
      | WOMEN      | WOMEN      |
      | DRESSES    | DRESSES    |
      | T-SHIRTS   | T-SHIRTS   |

  @Test @SearchBar
  Scenario Outline: User can search using the search bar
    When I enter search "<searchCriteria>" into the search bar
    Then the criteria should be displayed in the search results

    Examples:
      | searchCriteria              |
      | Blouse                      |
      | Faded Short Sleeve T-shirts |

  @Test @CreateAccount
  Scenario: User can create a new account by filling in personal information
    When I navigate to the create an account page
    And I enter my personal information into the form
    Then an account should be created

  @Test @AddItemToShoppingCart
  Scenario Outline: User can add an item to their shopping cart from the homepage
    And I select the "<pageLink>" link from the navigation bar
    When I select an "<item>" from the page
    And I add click the Add to Cart button
    Then the item should be added to the shopping cart

    Examples:
      | pageLink | item                        |
      | WOMEN    | Faded Short Sleeve T-shirts |

  @Test @ContactUs
  Scenario: User can use the contact us page to send message
    When I navigate to the contact us page
    And I create and send a message
    Then the successful message banner should appear



