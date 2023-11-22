package Gestures.iosGestures;

import driverSession.CreateSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public class IosPickerWheel {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateSession.createDriver("ios","simulator");
        System.out.println(driver.getSessionId());
        pickerWheel(driver);
    }

    public static void pickerWheel(AppiumDriver driver){
        driver.findElement(AppiumBy.accessibilityId("Picker View")).click();

        boolean flag = false;
        while(!flag){
            WebElement redPickerWheel = driver.findElement(AppiumBy.
                    iOSNsPredicateString("label == \"Red color component value\""));
            Map<String, Object> params = new HashMap<>();
            params.put("order", "next");
            params.put("offset", 0.15);
            params.put("element", ((RemoteWebElement) redPickerWheel).getId());
            driver.executeScript("mobile: selectPickerWheelValue", params);
            if(redPickerWheel.getText().equals("90")){
                flag = true;
            }
        }

        flag = false;
        while(!flag){
            WebElement redPickerWheel = driver.findElement(AppiumBy.
                    iOSNsPredicateString("label == \"Green color component value\""));
            Map<String, Object> params = new HashMap<>();
            params.put("order", "previous");
            params.put("offset", 0.15);
            params.put("element", ((RemoteWebElement) redPickerWheel).getId());
            driver.executeScript("mobile: selectPickerWheelValue", params);
            if(redPickerWheel.getText().equals("190")){
                flag = true;
            }
        }

        flag = false;
        while(!flag){
            WebElement redPickerWheel = driver.findElement(AppiumBy.
                    iOSNsPredicateString("label == \"Blue color component value\""));
            Map<String, Object> params = new HashMap<>();
            params.put("order", "next");
            params.put("offset", 0.15);
            params.put("element", ((RemoteWebElement) redPickerWheel).getId());
            driver.executeScript("mobile: selectPickerWheelValue", params);
            if(redPickerWheel.getText().equals("135")){
                flag = true;
            }
        }

    }
}
