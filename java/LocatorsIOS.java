import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocatorsIOS {

    AppiumDriver driver;

    @AndroidBy(accessibility = "radioButtonRow-tw")
    @AndroidFindBy(accessibility = "radioButtonRow-tw")
    @iOSXCUITFindBy(accessibility = "radioButtonRow-tw")
    private static WebElement element;

    public LocatorsIOS(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//*[contains(@content-desc,'customer name')]")
    @iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS 'customerName' AND visible==1")
    private List<WebElement> customerName;



    public static void main(String[] args) throws Exception {

       AppiumDriver driver = CreateDriverSession.initializeDriver("IOS");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("selectCountryLabel")));

        driver.findElement(AppiumBy.accessibilityId("selectCountryLabel")).click();

       //Accessibility
       WebElement accessElement = driver.findElement(AppiumBy.accessibilityId("radioButtonRow-tw"));
        System.out.println(accessElement.getText());

        //ID
       WebElement idElement = driver.findElement(AppiumBy.id("radioButtonRow-tw"));
       System.out.println(idElement.getText());

       //ClassName
        WebElement classElement =driver.findElement(AppiumBy.className("radioButtonTitle-it"));
        System.out.println(classElement.getText());

        //Name
        WebElement nameElement = driver.findElement(AppiumBy.name("radioButtonRow-tw"));
        System.out.println(nameElement.getText());

        //IOS Predicate - Native JS search strategy (powered by Apple)
        WebElement predicateElement = driver.findElement(AppiumBy.iOSNsPredicateString("label == \"radioButtonTitle-us\""));
        System.out.println(predicateElement.getText());

        //XPath
        WebElement xpathElement =driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"radioButtonTitle-do\"]"));
        System.out.println(xpathElement.getText());

        //IOSClass chain - By Appium: WebDriverAgent's layer over native XCTest lookup function calls
        WebElement iosChainElement =driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == \"radioButtonTitle-ca\"`]"));
        System.out.println(iosChainElement.getText());

        //IOS Predicate
         By predicate  = AppiumBy.iOSNsPredicateString("label CONTAINS 'Select' OR name =='dropDownTitleLabel'");
         By predicate1 =AppiumBy.iOSNsPredicateString("value CONTAINS 'Select' AND visible = 1");
        By predicate2 =AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND label == 'Select Country'");

        System.out.println(driver.findElement(predicate).getText());
        System.out.println(driver.findElement(predicate1).getText());
        System.out.println(driver.findElement(predicate2).getText());

        LocatorsIOS locatorsIOS = new LocatorsIOS(driver);
        System.out.println(element.getText());








    }
}
