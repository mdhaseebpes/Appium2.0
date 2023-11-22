package browserMobile;

import com.google.common.collect.ImmutableMap;
import driverSession.CreateBrowserSession;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AndAutomateBrowser {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateBrowserSession.createBrowserSession("ios","real");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://tesla.com");
//        driver.findElement(By.xpath("//*[@id=\"tds-menu-header-main\"]/div[2]/div/label/span")).click();
        driver.findElement(By.xpath("//*[@id=\"tds-site-header\"]/ol/li/button/span")).click();
//        driver.findElement(By.xpath("//*[@id=\"tds-menu-header-main\"]/div[2]/div/nav/nav[2]/ol/li[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"tds-global-menu\"]/dialog/section/ol/li[3]/a/span")).click();
//        driver.findElement(By.xpath("//*[@id=\"tesla-hero-showcase-1838\"]/div/div[1]/div/div[2]/div/div[6]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"tesla-hero-2846\"]/div[2]/div/section/div/a")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Select Your Car')]")));

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 600, "height", 600,
                "direction", "up",
                "percent", 0.75
        ));

/*        Dimension size = driver.manage().window().getSize();
        for(int i=0;i<2;i++){
            TouchAction t = new TouchAction(driver);
            t.press(PointOption.point(size.width / 2, (int) (size.height * 0.8)))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                    .moveTo(PointOption.point(size.width / 2, (int) (size.height * 0.2)))
                    .release()
                    .perform();
        }*/
//        Thread.sleep(10000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[@class='tds-btn tds-btn tds-btn--blue tds-btn--large']")
        )).click();
    //    driver.findElement(By.xpath("//button[@class='tds-btn tds-btn tds-btn--blue tds-btn--large']")).click();

        WebElement element = driver.findElement(By.xpath("//*[@id=\"FIRST_NAME\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.sendKeys("Haseeb");
    }
}
