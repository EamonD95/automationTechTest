Feature: User is able to run tests

  Background:
    Given I am on the homepage

  @Test @NavigationBar
  Scenario Outline: User navigates to different page using navigation bar
    When I select the "<pageLink>" link from the navigation bar
    Then I should be taken to the "<pageTitle>" page

    Examples:
      | pageLink | pageTitle |
      | WOMEN    | WOMEN     |
      | DRESSES  | DRESSES   |
      | T-SHIRTS | T-SHIRTS  |

  @Test @SearchBar
  Scenario: User can search using the search bar
    When I enter search "Blouse" into the search bar
    Then the criteria should be displayed in the search results

  @Test @CreateAccount
  Scenario: User can create a new account by filling in personal information
    When I navigate to the create an account page
    And I enter my personal information into the form
    Then an account should be created


