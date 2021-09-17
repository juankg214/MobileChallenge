package utils;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import pojos.EmulatorProperties;
import utils.reader.JSONReader;

public class Capabilities {

    public static DesiredCapabilities getDesiredCapabilities(){
        JSONReader<EmulatorProperties> routeJSONReader = new JSONReader<>(EmulatorProperties.class);
        EmulatorProperties props = routeJSONReader.readJson("src/main/resources/properties.json");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,props.platformName);
        caps.setCapability(MobileCapabilityType.VERSION,props.platformVersion);
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,props.deviceName);
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,60);
        caps.setCapability("appPackage",props.appPackage);
        caps.setCapability("appActivity",props.appActivity);
        caps.setCapability("udid", props.deviceName);
        return caps;
    }

}
