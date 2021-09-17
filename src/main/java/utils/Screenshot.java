package utils;

import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.apache.logging.log4j.Logger;
import javax.swing.text.Utilities;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.time.format.DateTimeFormatter;

public class Screenshot {
    private static final Logger Logger = LogManager.getLogger(Screenshot.class);

    public static void captureScreenshot(WebDriver driver, String name){
        try {
            TakesScreenshot ss = (TakesScreenshot) driver;
            File src = ss.getScreenshotAs(OutputType.FILE);
            Allure.addAttachment(name, new ByteArrayInputStream(ss.getScreenshotAs(OutputType.BYTES)));
            FileHandler.copy(src, new File("./screenshots/"+name+".png"));
            Logger.info("Screenshot taken");

        } catch (Exception e){
            Logger.info("Error taking screenshot");
        }
    }
}
