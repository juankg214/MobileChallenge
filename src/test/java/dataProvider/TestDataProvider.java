package dataProvider;

import hooks.Hooks;
import org.testng.annotations.DataProvider;
import utils.DataDeliver;

public class TestDataProvider extends Hooks {

    @DataProvider(name = "MovieOverview")
    public Object[][] movieOverview() {
        return DataDeliver.getInstance("src/main/resources/data.xlsx").getData("TestCase1");
    }

    @DataProvider(name = "MovieName")
    public Object[][] movieName() {
        return DataDeliver.getInstance("src/main/resources/data.xlsx").getData("TestCase2");
    }

    @DataProvider(name = "MovieRate")
    public Object[][] movieRate() {
        return DataDeliver.getInstance("src/main/resources/data.xlsx").getData("TestCase3");
    }


}
