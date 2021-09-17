package pages.components;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import pages.AccountPage;
import pages.BasePage;
import pages.SearchPage;



public class NavBar extends BasePage {

    private static final Logger logger = LogManager.getLogger(NavBar.class);

    @AndroidFindBy(accessibility = "Search")
    private AndroidElement searchButton;

    @AndroidFindBy(accessibility = "You")
    private AndroidElement accountButton;

    public NavBar(AndroidDriver<AndroidElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public SearchPage goToSearch(){
        searchButton.click();
        logger.info("Going to search");
        return new SearchPage(driver);
    }

    public AccountPage goToAccount(){
        accountButton.click();
        logger.info("Going to Account");
        return new AccountPage(driver);
    }
}
