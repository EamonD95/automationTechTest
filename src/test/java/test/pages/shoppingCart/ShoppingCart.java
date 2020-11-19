package test.pages.shoppingCart;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.hamcrest.Factory;
import org.openqa.selenium.support.ui.Select;
import test.pages.Page;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import java.util.Random;

public class ShoppingCart extends Page {

    @FindBy(xpath = "//td[@class='cart_description']//a")
    public WebElementFacade shoppingCartDescription;

    public void assertShoppingCartPageTitle() {
        assertTitle("SHOPPING-CART SUMMARY");
    }


}
