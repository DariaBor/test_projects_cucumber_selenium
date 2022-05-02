package pages;

import helpers.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static helpers.WebDriverBase.driver;

public class MainPage {
    @FindBy(id = "btn-add-device")
    private WebElement addDeviceButton;

    @FindBy(id = "btn-delete-device")
    private WebElement deleteDeviceButton;

    @FindBy(id = "btn-logout")
    protected WebElement logOutButton;

    @FindBy(id = "textfield-Devicename")
    private WebElement deviceName;

    @FindBy(xpath = "//*[@class='material-icons mdl-selectfield__arrow']")
    private WebElement deviceOperationSystem;

    @FindBy(id = "textfield-Countrycode")
    private WebElement deviceCountyCode;

    @FindBy(id = "btn-save-device")
    private WebElement saveButton;

    @FindBy(xpath = "//li[@class='mdl-menu__item']")
    private List<WebElement> osList;

    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    public void addDevice(String name, String os, String countryCode) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        addDeviceButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='mdl-dialog__title']")));
        deviceName.sendKeys(name);
        selectOperationsystem(os);
        deviceCountyCode.sendKeys(countryCode);
        saveButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[.='" + os + "']")));
        // no check for name uniqeness and if really the deivce was added, need additional info from BE/FE
    }

    private void selectOperationsystem(String os) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        deviceOperationSystem.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@class='mdl-menu__item']")));
        for (WebElement item : osList) {
            if (item.getText().equals(os)) {
                item.click();
                break;
            }
        }
    }
}
