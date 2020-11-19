package test.pages.contactUs;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.Select;
import test.pages.Page;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ContactUs extends Page {

    @FindBy(xpath = "//select[@id='id_contact']")
    public WebElementFacade subjectHeadingDropdown;

    @FindBy(xpath = "//input[@id='email']")
    public WebElementFacade emailAddressTextbox;

    @FindBy(xpath = "//input[@id='id_order']")
    public WebElementFacade orderReferenceTextbox;

    @FindBy(xpath = "//textarea[@id='message']")
    public WebElementFacade messageTextbox;

    @FindBy(xpath = "//span[@class='action']")
    public WebElementFacade chooseFileButton;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    public WebElementFacade contactUsSuccessMessage;

    @FindBy(xpath = "//button[@id='submitMessage']")
    public WebElementFacade sendButton;

    public void assertContactUsPageTitle() {
        assertTitle("CUSTOMER SERVICE - CONTACT US");
    }

    public void selectSubjectHeading(String subjectHeading) {
        Select option = new Select(subjectHeadingDropdown);
        option.selectByValue(subjectHeading);
    }

    public void enterEmailAddress() {
        String randomEmailAddress = new Random().nextInt(10000) + "@mail.com";
        emailAddressTextbox.sendKeys(randomEmailAddress);
    }

    public void enterContactMessage() {
        typeInto(messageTextbox, "Test Message");
    }

    public void assertCustomerServiceSuccessMessage() {
        assertThat(contactUsSuccessMessage.getText(), is("Your message has been successfully sent to our team."));
    }

    public void sendContactUsMessage() {
        selectSubjectHeading("2");
        enterEmailAddress();
        enterContactMessage();
        clickOn(sendButton);
    }

}
