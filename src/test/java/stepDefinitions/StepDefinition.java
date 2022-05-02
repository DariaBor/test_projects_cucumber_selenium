package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import pages.MainPage;

import static helpers.WebDriverBase.driver;

public class StepDefinition {
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();

    @Given("User enters username {string} and password {string} to log in")
    public void user_logs_in(String username, String password) {
        loginPage.logIn(username, password);
    }

    @Then("User adds device with name {string}, os {string} and country code {string}")
    public void add_device(String name, String os, String countryCode) {
        mainPage.addDevice(name, os, countryCode);
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
