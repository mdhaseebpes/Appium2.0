package locators;

import driverSession.CreateSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IosLocators {


    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateSession.createDriver("ios","real");

      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));


     WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(10));
     wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.accessibilityId("Activity Indicators"))));


       WebElement myElementIOSAccessibility = driver.findElement(AppiumBy.accessibilityId("Activity Indicators"));
        System.out.println(myElementIOSAccessibility.getText());

        WebElement myElementIOSClassName =  driver.findElement(AppiumBy.className("XCUIElementTypeStaticText"));
        System.out.println(myElementIOSClassName.getText());

        WebElement myElementIOSId =  driver.findElement(AppiumBy.id("Alert Views"));
        System.out.println(myElementIOSClassName.getText());

        //applicable only for IOS and not applicable for Android -- name locator
        WebElement myElementIOSName =  driver.findElement(AppiumBy.name("Alert Views"));
        System.out.println(myElementIOSName.getText());

        WebElement myElementIOSPredicateString =  driver.findElement(AppiumBy.iOSNsPredicateString("label=='SearchViewControllers'"));
        System.out.println(myElementIOSPredicateString.getText());


        WebElement myElementIOSXpath =  driver.findElement
                (AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Search\"]/..//XCUIElementTypeStaticText[@name=\"SearchViewControllers\"]"));
        System.out.println(myElementIOSXpath.getText());

        //IOSClass chain - By Appium: WebDriverAgent's layer over native XCTest lookup function calls
       // WebElement myElementIOSChain =driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText['label==\"SearchViewControllers\"]"));
       // System.out.println(myElementIOSChain.getText());

        //IOS Predicate
        By predicate  = AppiumBy.iOSNsPredicateString("label CONTAINS 'Segmented' OR name CONTAINS 'Segmented'");
        By predicate1 =AppiumBy.iOSNsPredicateString("value CONTAINS 'Segmented' AND visible = 1");
        By predicate2 =AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND label == 'Image View'");

        System.out.println(driver.findElement(predicate).getText());
        System.out.println(driver.findElement(predicate1).getText());
        System.out.println(driver.findElement(predicate2).getText());

    }
}
