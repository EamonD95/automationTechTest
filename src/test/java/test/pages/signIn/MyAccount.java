package test.pages.signIn;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import test.pages.Page;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MyAccount extends Page {

    @Managed
    WebDriver driver;

    @FindBy(xpath = "//p[@class='info-account']")
    public WebElementFacade welcomeToAccountMessage;

    public void assertWelcomeToAccountMessage(){
        assertThat(welcomeToAccountMessage.getText(), is("Welcome to your account. Here you can manage all of your personal information and orders."));
    }
}
