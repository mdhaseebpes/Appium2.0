import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By alertViews = AppiumBy.accessibilityId("Alert Views");
        By okayCancel = AppiumBy.accessibilityId("Okay / Cancel");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(alertViews)).click();
     //   driver.findElement(alertViews).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(okayCancel)).click();
     //   driver.findElement(okayCancel).click();

// why not to use both implicit and explicit wait !!!???
    }
}
