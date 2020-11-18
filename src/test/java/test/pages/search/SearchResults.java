package test.pages.search;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import test.pages.Page;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchResults extends Page {

    @Managed
    WebDriver driver;

    @FindBy(xpath = "//ul[@class='product_list grid row']//a[@class='product-name']")
    public WebElementFacade firstSearchResult;

}
