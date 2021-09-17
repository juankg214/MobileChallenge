package utils;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.List;

public class Scroll {

    private final AndroidDriver<AndroidElement> driver;
    private static final Logger logger = LogManager.getLogger(Scroll.class);
    public Scroll(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    public void scrollDown() {

        Dimension dimension = driver.manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight()*0.5);
        int scrollEnd = (int) (dimension.getHeight()*0.2);

        new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(0,scrollStart))
                .waitAction(WaitOptions.waitOptions( Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0,scrollEnd))
                .release().perform();
    }


    public List<AndroidElement> getItemViewsList(int method, String path){

        if(method == 1){
            return driver.findElementsById(path);
        }

        return null;
    }

    public AndroidElement scrollTillView(int method, String path)   {

        try {
            while (getItemViewsList(method,path).size() == 0){
                scrollDown();
                Thread.sleep(500);
            }

        } catch (Exception e){
            logger.info(e.getMessage());
        }

        logger.info("Found");

        return getItemViewsList(method,path).get(0);


    }

}
