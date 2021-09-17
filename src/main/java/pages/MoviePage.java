package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.Scroll;

public class MoviePage  extends BasePage {

    @AndroidFindBy(id = "com.imdb.mobile:id/plot_overview")
    private AndroidElement overviewText;

    @AndroidFindBy(id = "com.imdb.mobile:id/rate_title_button")
    private AndroidElement rateButton;

    @AndroidFindBy(id = "com.imdb.mobile:id/title")
    private AndroidElement savedMessage;

    private Scroll scroll;

    public MoviePage(AndroidDriver<AndroidElement> driver) {
        super(driver);
        scroll = new Scroll(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String getOverviewText(){
        return overviewText.getText();
    }

    public void addToWatchList(){
          AndroidElement addToWatchListButton =  scroll.scrollTillView(1,"com.imdb.mobile:id/state_off");
          addToWatchListButton.click();
    }

    public AndroidElement goToRate()  {
        return scroll.scrollTillView(1,"com.imdb.mobile:id/star_your");
    }

    public void selectRate(String score){
        MobileElement star = driver.findElementById("com.imdb.mobile:id/star_"+score);
        star.click();
    }

    public void rate(String score){
        goToRate().click();
        selectRate(score);
        rateButton.click();
    }

    public String getSavedMessage(){
        return savedMessage.getText();
    }

}
