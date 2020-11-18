package test.pages.signIn;

import cucumber.api.java.eo.Se;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.yecht.Data;
import test.pages.Page;

import java.util.Random;

public class CreateAnAccount extends Page {

    @Managed
    WebDriver driver;

    @FindBy(xpath = "//div[@id='uniform-id_gender1']")
    public WebElementFacade mrRadioButton;

    @FindBy(xpath = "//div[@id='uniform-id_gender2']")
    public WebElementFacade mrsRadioButton;

    @FindBy(xpath = "//input[@id='customer_firstname']")
    public WebElementFacade firstNameField;

    @FindBy(xpath = "//input[@id='customer_lastname']")
    public WebElementFacade lastNameField;

    @FindBy(xpath = "//input[@id='email']")
    public WebElementFacade emailField;

    @FindBy(xpath = "//input[@id='passwd']")
    public WebElementFacade passwordField;

    @FindBy(xpath = "//select[@id='days']")
    public WebElementFacade dateOfBirthDaysDropdown;

    @FindBy(xpath = "//select[@id='months']")
    public WebElementFacade dateOfBirthMonthsDropdown;

    @FindBy(xpath = "//select[@id='years']")
    public WebElementFacade dateOfBirthYearsDropdown;

    @FindBy(xpath = "//input[@id='address1']")
    public WebElementFacade addressField;

    @FindBy(xpath = "//input[@id='city']")
    public WebElementFacade cityField;

    @FindBy(xpath = "//select[@id='id_state']")
    public WebElementFacade stateDropdown;

    @FindBy(xpath = "//input[@id='postcode']")
    public WebElementFacade postcodeField;

    @FindBy(xpath = "//select[@id='id_country']")
    public WebElementFacade countryDropdown;

    @FindBy(xpath = "//input[@id='phone_mobile']")
    public WebElementFacade mobilePhoneField;

    @FindBy(id = "submitAccount")
    public WebElementFacade registerButton;

    public void selectDateOfBirthDay(String dayOneToThirtyOne) {
        Select day = new Select(dateOfBirthDaysDropdown);
        day.selectByValue(dayOneToThirtyOne);
    }

    public void selectDateOfBirthMonth(String monthOneToTwelve) {
        Select month = new Select(dateOfBirthMonthsDropdown);
        month.selectByValue(monthOneToTwelve);
    }

    public void selectDateOfBirthYear(String theYear) {
        Select year = new Select(dateOfBirthYearsDropdown);
        year.selectByValue(theYear);
    }

    public void selectState(String theState) {
        Select state = new Select(stateDropdown);
        state.selectByValue(theState);
    }

    public void enterPostCode() {
        String randomPostCode = new Random().nextInt(100000) + "";
        postcodeField.sendKeys(randomPostCode);
    }

    public void selectCountry(String theCountry) {
        Select country = new Select(countryDropdown);
        country.selectByValue(theCountry);
    }

    public void enterMobileNumber() {
        String randomMobileNumber = new Random().nextInt(10000000) + "";
        mobilePhoneField.sendKeys(randomMobileNumber);
    }

    public void enterCreateAnAccountInformation() {
        clickOn(mrRadioButton);
        typeInto(firstNameField, "John");
        typeInto(lastNameField, "Smith");
        String randomString = generateRandomString();
        typeInto(passwordField, randomString);
        selectDateOfBirthDay("1");
        selectDateOfBirthMonth("10");
        selectDateOfBirthYear("1995");
        typeInto(addressField, randomString + " Street");
        typeInto(cityField, randomString + " Town");
        selectState("43");
        enterPostCode();
        selectCountry("21");
        enterMobileNumber();
        clickOn(registerButton);
    }
}
