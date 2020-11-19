package glue;

import config.Environments;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import test.pages.Page;
import test.pages.contactUs.ContactUs;
import test.pages.dresses.Dresses;
import test.pages.homepage.Homepage;
import test.pages.search.SearchResults;
import test.pages.shoppingCart.ShoppingCart;
import test.pages.signIn.CreateAnAccount;
import test.pages.signIn.MyAccount;
import test.pages.signIn.SignIn;
import test.pages.tshirts.TShirts;
import test.pages.women.Women;

import static jnr.posix.util.MethodName.getMethodName;
import static net.serenitybdd.core.Serenity.pendingStep;
import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static net.serenitybdd.core.Serenity.setSessionVariable;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class genericTestStepDefs extends Page {

    Homepage homepage;

    Women women;

    Dresses dresses;

    TShirts tShirts;

    SearchResults searchResults;

    SignIn signIn;

    CreateAnAccount createAnAccount;

    MyAccount myAccount;

    ShoppingCart shoppingCart;

    ContactUs contactUs;

    @Given("^I am on the homepage$")
    public void navigateToHomepage() {
        homepage.navigateToShopHomepage();
    }

    @When("^I select the \"([^\"]*)\" link from the navigation bar$")
    public void selectLinkFromNavigationBar(String navLink) {
        switch (navLink.toUpperCase()) {
            case "WOMEN":
                clickOn(homepage.womenPageLink);
                break;
            case "DRESSES":
                clickOn(homepage.dressesPageLink);
                break;
            case "T-SHIRTS":
                clickOn(homepage.tshirtsPageLink);
                break;
            default:
                pendingStep(navLink + " is not defined within " + getMethodName());
        }
    }

    @Then("^I should be taken to the \"([^\"]*)\" page$")
    public void assertThatUserHasBeenTakenToPageFromNavigationBar(String navLink) {
        switch (navLink.toUpperCase()) {
            case "WOMEN":
                women.assertWomenPageTitle();
                break;
            case "DRESSES":
                dresses.assertDressesPageTitle();
                break;
            case "T-SHIRTS":
                tShirts.assertTShirtsPageTitle();
                break;
            default:
                pendingStep(navLink + " is not definied within " + getMethodName());
        }
    }

    @When("^I enter search \"([^\"]*)\" into the search bar$")
    public void enterCriteriaAndSearch(String searchCriteria) {
        switch (searchCriteria.toUpperCase()) {
            case "BLOUSE":
                typeInto(searchField, "Blouse");
                setSessionVariable("searchCriteria").to(searchCriteria);
                break;
            case "FADED SHORT SLEEVE T-SHIRTS":
                typeInto(searchField, "Faded Short Sleeve T-shirts");
                setSessionVariable("searchCriteria").to(searchCriteria);
                break;
            default:
                pendingStep(searchCriteria + " is not defined within " + getMethodName());
        }
        clickOn(searchButton);
    }

    @Then("^the criteria should be displayed in the search results$")
    public void assertSearchCriteriaInSearchResults() {
        assertThat(searchResults.firstSearchResult.getText(), is(sessionVariableCalled("searchCriteria").toString()));
    }

    @When("^I navigate to the create an account page$")
    public void navigateToCreateAnAccountPage() {
        clickOn(signInLink);
        String randomEmail = generateRandomString();
        typeInto(signIn.createEmailAddressField, randomEmail + "@example.com");
        clickOn(signIn.createAnAccountButton);
    }

    @When("^I enter my personal information into the form$")
    public void enterPersonalInformationIntoForm() {
        createAnAccount.enterCreateAnAccountInformation();
    }

    @Then("^an account should be created$")
    public void assertThatNewAccountHasBeenCreated() {
        myAccount.assertWelcomeToAccountMessage();
    }

    @When("^I select an \"([^\"]*)\" from the page$")
    public void selectItemFromStorePage(String item) {
        switch (item.toUpperCase()) {
            case "FADED SHORT SLEEVE T-SHIRTS":
                women.selectFadedShortSleeveTShirt();
                setSessionVariable("item").to(item);
                break;
            default:
                pendingStep(item + " is not defined within " + getMethodName());
        }
    }

    @And("^I add click the Add to Cart button$")
    public void clickAddToCartButton() {
        clickOn(addToCartButton);
    }

    @Then("^the item should be added to the shopping cart$")
    public void assertItemAddedToShoppingCart() {
        clickOn(proceedToCheckoutButton);
        shoppingCart.assertShoppingCartPageTitle();
        assertThat(shoppingCart.shoppingCartDescription.getText(), is(sessionVariableCalled("item").toString()));
    }

    @When("^I navigate to the contact us page$")
    public void navigateToContactUsPage() {
        clickOn(contactUsLink);
        contactUs.assertContactUsPageTitle();
    }

    @And("^I create and send a message$")
    public void createAndSendAMessage() {
        contactUs.sendContactUsMessage();
    }

    @Then("^the successful message banner should appear$")
    public void assertContactUsSuccessMessageIsDisplayed() {
        contactUs.assertCustomerServiceSuccessMessage();
    }
}
