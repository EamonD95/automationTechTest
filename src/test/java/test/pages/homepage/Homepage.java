package test.pages.homepage;

import config.Environments;
import test.pages.Page;

public class Homepage extends Page {

    public void navigateToShopHomepage() {
        String baseURL = "";

        baseURL = Environments.HOME.getEnvironmentURL();
        getDriver().get(baseURL);
    }

}