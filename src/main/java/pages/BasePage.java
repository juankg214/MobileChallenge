package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BasePage {

    protected AndroidDriver<AndroidElement> driver;

    public BasePage(AndroidDriver<AndroidElement>  driver) {
        this.driver = driver;
    }
}
