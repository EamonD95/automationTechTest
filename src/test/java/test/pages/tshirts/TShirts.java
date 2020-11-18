package test.pages.tshirts;

import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import test.pages.Page;

public class TShirts extends Page {

    @Managed
    WebDriver driver;

    public void assertTShirtsPageTitle() {
        assertTitle("T-SHIRTS");
    }
}
