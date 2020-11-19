package test.pages.women;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import test.pages.Page;

public class Women extends Page {

    @Managed
    WebDriver driver;

    @FindBy(xpath = "//a[contains(@class, 'product_img_link') and contains(@title, 'Faded Short Sleeve T-shirts')]")
    public WebElementFacade fadedShortSleeveTShirt;

    @FindBy(xpath = "//a[contains(@class, 'product_img_link') and contains(@title, 'Blouse')]")
    public WebElementFacade blouse;

    public void selectFadedShortSleeveTShirt() {
        clickOn(fadedShortSleeveTShirt);
    }

    public void selectBlouse() {
        clickOn(blouse);
    }

    public void assertWomenPageTitle() {
        assertTitle("WOMEN");
    }
}
