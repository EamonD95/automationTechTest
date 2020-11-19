package test.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.components.Dropdown;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import net.thucydides.core.steps.StepEventBus;
import org.openqa.selenium.support.ui.Select;

public class Page extends PageObject {

    @Managed
    public
    WebDriver driver;

    private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyz";

    @FindBy(xpath = "//a[@title='My Store']")
    public WebElementFacade homepageLink;

    @FindBy(xpath = "//h1")
    public WebElementFacade pageTitle;

    @FindBy(xpath = "//button[@name='submit_search']")
    public WebElementFacade searchButton;

    @FindBy(id = "search_query_top")
    public WebElementFacade searchField;

    @FindBy(xpath = "//a[@title='Women']")
    public WebElementFacade womenPageLink;

    @FindBy(xpath = "(//a[@title='Dresses'])[2]")
    public WebElementFacade dressesPageLink;

    @FindBy(xpath = "(//a[@title='T-shirts'])[2]")
    public WebElementFacade tshirtsPageLink;

    @FindBy(xpath = "//a[@class='login']")
    public WebElementFacade signInLink;

    @FindBy(xpath = "//p[@id='add_to_cart']")
    public WebElementFacade addToCartButton;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    public WebElementFacade proceedToCheckoutButton;

    @FindBy(xpath = "//a[@title='Contact Us']")
    public WebElementFacade contactUsLink;


    public void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void assertTitle(String title) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertThat(getHeaderText(), containsString(title));
    }

    private String getHeaderText() {
        return pageTitle.getText();
    }

    public boolean isElementDisplayed(WebElementFacade element) {
        try {
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | StaleElementReferenceException | NullPointerException e) {
            return false;
        }
    }

    private int getRandomNumber() {
        Random randomGenerator = new Random();

        int randomInt = randomGenerator.nextInt(CHAR_LIST.length());

        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }

    protected String generateRandomString() {
        StringBuilder randStr = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int number = getRandomNumber();
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }

        return randStr.toString();
    }
}
