package locators;

import driverSession.CreateSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryExample {


     AppiumDriver driver;
   // @FindBy(id="")
    @AndroidFindBy(accessibility = "Activity Indicators")
    @iOSXCUITFindBy(accessibility = "Activity Indicators")
    private static WebElement activity;

    //@FindBy(className = "")
    @AndroidFindBy(uiAutomator="new UiSelector().description(\"Content\")")
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Content' OR visible =1 ")
    private static WebElement content;

    public PageFactoryExample(AppiumDriver driver) {
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public static void main(String[] args) throws Exception {
      AppiumDriver  driver = CreateSession.createDriver("ios","real");
        PageFactoryExample pageFactoryExample = new PageFactoryExample(driver);

        System.out.println(content.getText());
        System.out.println(activity.getText());
    }
}
