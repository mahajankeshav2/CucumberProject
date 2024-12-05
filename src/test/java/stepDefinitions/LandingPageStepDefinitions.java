package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.LandingPage;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;


public class LandingPageStepDefinitions {
    public WebDriver driver;
    TestContextSetup textContext;
    LandingPage landingPage;
    public LandingPageStepDefinitions(TestContextSetup textContext) {
        this.textContext=textContext;
        landingPage= textContext.pageObjectManager.getLandingPage();
    }
    @Given("User is on GreenCart Landing page")
    public void userIsOnGreenCartLandingPage() {

    }

    @When("^user searched with shortname (.+) and extract actual name of product$")
    public void userSearchedWithShortnameAndExtractActualNameOfProduct(String shortName) throws InterruptedException {

        landingPage.searchItem(shortName);
        Thread.sleep(2000);
        textContext.landingProdName= landingPage.getProductName().split("-")[0].trim();
        System.out.println(textContext.landingProdName+" is extracted from Home Page");

    }

    @And("Added {string} items of selected product to cart")
    public void addedItemsOfSelectedProductToCart(String quantity) {
        landingPage.incrementItem(Integer.parseInt(quantity));
        landingPage.clickAddToCart();
    }
}
