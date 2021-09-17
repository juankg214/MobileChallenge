package tests;

import dataProvider.TestDataProvider;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;

import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.AccountPage;
import pages.LandingPage;
import pages.MoviePage;
import pages.SearchPage;
import pages.components.NavBar;
import utils.DriverFactory;

public class Tests extends TestDataProvider {
    private static final Logger logger = LogManager.getLogger(Tests.class);

    @Test(dataProvider = "MovieOverview")
    public void validOverviewTextMovie(String movie, String overview) {
        logger.info("validOverviewTextMovie started ...");
        AndroidDriver driver = DriverFactory.getInstance().getDriver();
        NavBar navBar = new NavBar(driver);

        LandingPage landingPage = new LandingPage(driver);

        landingPage.dennyPermission();
        landingPage.closePopUp();
        landingPage.dontSignIn();

        SearchPage searchPage = navBar.goToSearch();
        searchPage.closePopUp();
        searchPage.search(movie);
        MoviePage moviePage = searchPage.goToMovie();

        Assert.assertEquals(moviePage.getOverviewText(),overview + "asd");
        logger.info("validOverviewTextMovie finished ...");
    }

    @Test(dataProvider = "MovieName")
    public void addMovieToWatchList(String name)   {
        logger.info("addMovieToWatchList started ...");
        AndroidDriver driver = DriverFactory.getInstance().getDriver();
        NavBar navBar = new NavBar(driver);

        LandingPage landingPage = new LandingPage(driver);
        landingPage.dennyPermission();
        landingPage.closePopUp();
        landingPage.login();

        SearchPage searchPage = navBar.goToSearch();
        searchPage.closePopUp();
        searchPage.search(name);

        MoviePage moviePage = searchPage.goToMovie();
        moviePage.addToWatchList();

        AccountPage accountPage = navBar.goToAccount();
        accountPage.closePopUp();

        Assert.assertEquals(name,accountPage.getTextFormWatchListFirstMovie());
        logger.info("addMovieToWatchList finished ...");
    }

    @Test(dataProvider = "MovieRate")
    public void rateMovie(String name, String rate)   {
        logger.info("rateMovie started ...");
        AndroidDriver driver = DriverFactory.getInstance().getDriver();
        NavBar navBar = new NavBar(driver);

        LandingPage landingPage = new LandingPage(driver);
        landingPage.dennyPermission();
        landingPage.closePopUp();
        landingPage.login();

        SearchPage searchPage = navBar.goToSearch();
        searchPage.closePopUp();
        searchPage.search(name);

        MoviePage moviePage = searchPage.goToMovie();
        moviePage.rate(rate);

        Assert.assertEquals("Rating saved",moviePage.getSavedMessage());
        logger.info("rateMovie finished ...");
    }






}
