package hooks;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.Capabilities;
import utils.DriverFactory;
import utils.Screenshot;

import javax.swing.text.Utilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Hooks  {


    @BeforeMethod
    public void overviewTextMatch() throws MalformedURLException {
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        DriverFactory.getInstance().setDriver(new AndroidDriver<AndroidElement>(url, Capabilities.getDesiredCapabilities()));
        AndroidDriver driver = DriverFactory.getInstance().getDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void teardown(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            Screenshot.captureScreenshot(DriverFactory.getInstance().getDriver(), result.getName());
        }
    }
}
