package test.pages.women;

import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import test.pages.Page;

public class Women extends Page {

    @Managed
    WebDriver driver;

    public void assertWomenPageTitle() {
        assertTitle("WOMEN");
    }
}
