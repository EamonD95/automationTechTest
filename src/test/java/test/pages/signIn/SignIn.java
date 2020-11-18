package test.pages.signIn;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import test.pages.Page;

public class SignIn extends Page {

    @Managed
    WebDriver driver;

    @FindBy(xpath = "//input[@id='email_create']")
    public WebElementFacade createEmailAddressField;

    @FindBy(xpath = "//button[@id='SubmitCreate']")
    public WebElementFacade createAnAccountButton;

    @FindBy(xpath = "//input[@id='email']")
    public WebElementFacade alreadyRegisteredEmailField;

    @FindBy(xpath = "//input[@id='passwd']")
    public WebElementFacade alreadyRegisteredPasswordField;

}
