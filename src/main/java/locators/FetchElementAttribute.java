package locators;

import driverSession.CreateSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class FetchElementAttribute {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateSession.createDriver("ios", "simulator");

        By accessibility = AppiumBy.accessibilityId("Activity Indicators");
        System.out.println("label:" + driver.findElement(accessibility).getText());
        System.out.println("label:" + driver.findElement(accessibility).getAttribute("label"));
        System.out.println("value:" + driver.findElement(accessibility).getAttribute("value"));
        System.out.println("enabled:" + driver.findElement(accessibility).getAttribute("enabled"));
        System.out.println("selected:" + driver.findElement(accessibility).getAttribute("selected"));
        System.out.println("visible:" + driver.findElement(accessibility).getAttribute("visible"));

        System.out.println("selected:" + driver.findElement(accessibility).isSelected());
        System.out.println("enabled:" + driver.findElement(accessibility).isEnabled());
        System.out.println("displayed:" + driver.findElement(accessibility).isDisplayed());
    }
}
// How to fetch element attributes?