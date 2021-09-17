package utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
    ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();

    private static DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance(){
        return instance;
    }

    public AndroidDriver getDriver(){
        return driver.get();
    }

    public void setDriver(AndroidDriver driver){
        this.driver.set(driver);
    }


}
