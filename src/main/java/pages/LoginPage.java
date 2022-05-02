package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static helpers.WebDriverBase.driver;

public class LoginPage {

    @FindBy(id = "textfield-Username")
    private WebElement userNameInput;

    @FindBy(id = "textfield-Password")
    private WebElement passwordInput;

    @FindBy(id = "btn-login")
    private WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public MainPage logIn(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        wait.until(ExpectedConditions.visibilityOf(new MainPage().logOutButton));
        return new MainPage();
    }
}
