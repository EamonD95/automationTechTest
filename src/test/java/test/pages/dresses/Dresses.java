package test.pages.dresses;

import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import test.pages.Page;

public class Dresses extends Page {

    public void assertDressesPageTitle() {
        assertTitle("DRESSES");
    }
}
