package browserMobile;

import driverSession.CreateBrowserSession;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class iOSAutomateBrowser {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateBrowserSession.createBrowserSession("iOS","real");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://tesla.com");
        driver.findElement(By.className("tds-menu-header-main--trigger_icon")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"tds-menu-header-main\"]/div[2]/div/nav/nav[2]/ol/li[3]/a")).click();
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By
                .xpath("//*[@id=\"tesla-hero-showcase-1838\"]/div/div[1]/div/div[2]/div/div[6]/a"))).click();
  //      driver.findElement(By.xpath("//*[@id=\"tesla-hero-showcase-1838\"]/div/div[1]/div/div[2]/div/div[6]")).click();
        Thread.sleep(3000);

        Map<String, Object> params = new HashMap<>();
        params.put("direction", "up");
        driver.executeScript("mobile: swipe", params);

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div/div[3]/button")).click();
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.id("FIRST_NAME"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(3000);
        element.sendKeys("Haseeb");


    }
}
