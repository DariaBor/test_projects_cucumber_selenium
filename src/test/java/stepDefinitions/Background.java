package stepDefinitions;

import helpers.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Background {
    @Given("Browser is opened")
    public void browser_is_opened() {
        Utils.openWebBrowser();
    }

    @Then("Open app")
    public void navigate_to_the_Heroku_landing_page()  {
        Utils.startAppication();
    }
}
