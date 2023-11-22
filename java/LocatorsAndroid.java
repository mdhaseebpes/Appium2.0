import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class LocatorsAndroid {

    public static void main(String[] args) throws Exception {

        AppiumDriver driver= CreateDriverSession.initializeDriver("Android");

        //Android locators
        //Accessibility ID - unique_element_name
        WebElement myElement = driver.findElement(AppiumBy.accessibilityId("Accessibility"));
        System.out.println(myElement.getText());

        //ID - app_package/resource-id
        WebElement myElementID =driver.findElement(AppiumBy.id("android:id/text1"));
        System.out.println(myElementID.getText());

        //class Name - android.widget.TextView
        WebElement myElementClassName =driver.findElement(AppiumBy.className("android.widget.TextView"));
        System.out.println(myElementClassName.getText());

        //Xpath
        WebElement myElementXpath = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Content\"]"));
        System.out.println(myElementXpath.getText());

        WebElement myElementXpath1 =driver.findElement(AppiumBy.xpath("//*[@text='Accessibility']"));
        System.out.println(myElementXpath1.getText());

        //UiAutomator2(UI Selector) - UI Automator API, use the UiSelector class -
        //new UiSelector().text(\"Animation\")
       WebElement myElementUIAutomator = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Animation\")"));
       System.out.println(myElementUIAutomator.getText());

        WebElement myElementUIAutomator1 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\")"));
        System.out.println(myElementUIAutomator1.getText());

        WebElement myElementUIAutomator2 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"Accessibility\")"));
        System.out.println(myElementUIAutomator2.getText());

        List<WebElement> myElementUIAutomator3 = driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")"));
        System.out.println("UiAutomator2(UI Selector)");
        for(WebElement e : myElementUIAutomator3){
            System.out.println(e.getText());
        }

        //Image - base64_encoded_string - matches with base64 encoded image file
        //driver.findElement(AppiumBy.image(""));


    }
}
