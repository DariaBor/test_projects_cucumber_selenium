package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static helpers.WebDriverBase.driver;
import static helpers.WebDriverBase.getWebDriver;

public class Utils {
    private static final String BASE_URL = "https://frontend-wandera.herokuapp.com/";
    public static void openWebBrowser(){

        getWebDriver("chrome");
    }

    public static void closeWebBrowser(){
        driver.close();
        driver.quit();
    }

    public static void startAppication() {
        driver.get(BASE_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='mdl-card__title-text']")));
    }
}
