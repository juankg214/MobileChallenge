package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.Scroll;

public class AccountPage extends BasePage {

    @AndroidFindBy(id = "com.imdb.mobile:id/exit")
    private AndroidElement popUpCloseButton;



    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]")
    private AndroidElement movieName;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ImageView[2]")
    private AndroidElement deleteFromWatchList;

    private Scroll scroll;

    public AccountPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
        scroll = new Scroll(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void closePopUp(){
        popUpCloseButton.click();
    }

    public void deleteFromWatchList(){
        deleteFromWatchList.click();
    }

    public String getTextFormWatchListFirstMovie(){
        scroll.scrollDown();
        String name = movieName.getText();
        deleteFromWatchList();
        return name;
    }



}
