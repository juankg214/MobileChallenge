package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage{

    @AndroidFindBy(id = "com.imdb.mobile:id/exit")
    private AndroidElement popUpCloseButton;

    @AndroidFindBy(id = "com.imdb.mobile:id/search_src_text")
    private AndroidElement searchBar;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]")
    private AndroidElement movie;



    public SearchPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void closePopUp(){
        popUpCloseButton.click();
    }

    public void search(String text){
        searchBar.click();
        searchBar.sendKeys(text);
        driver.hideKeyboard();
    }

    public MoviePage goToMovie(){
        movie.click();
        return new MoviePage(driver);
    }



}
