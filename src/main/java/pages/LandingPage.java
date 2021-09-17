package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage{

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    private AndroidElement dennyButton;

    @AndroidFindBy(id = "android:id/button2")
    private AndroidElement popUpClose;

    @AndroidFindBy(id = "com.imdb.mobile:id/splash_not_now")
    private AndroidElement notNowButton;

    @AndroidFindBy(id = "com.imdb.mobile:id/facebook_oauth")
    private AndroidElement loginWithFacebook;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.widget.Button")
    private AndroidElement continueWithCredentials;


    public LandingPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    public void dennyPermission(){
        dennyButton.click();
    }

    public void closePopUp(){
        popUpClose.click();
    }

    public void dontSignIn(){
        notNowButton.click();
    }

    public void login(){
        loginWithFacebook.click();
        continueWithCredentials.click();
    }

}
