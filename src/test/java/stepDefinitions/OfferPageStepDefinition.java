package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefinition {
    public WebDriver driver;
    public String offerProdName;
    TestContextSetup textContext;
    public OfferPageStepDefinition(TestContextSetup textContext) {
        this.textContext=textContext;
    }
    @Then("^user searched for (.+) shortname in offers page$")
    public void userSearchedForSameShortnameInOffersPageToCheckIfProductExists(String shortName) throws InterruptedException {
        switchToOfferPage();
        OfferPage offerPage = textContext.pageObjectManager.getOfferPage();;
        offerPage.searchItem(shortName);
        Thread.sleep(2000);

        offerProdName=offerPage.getProductName();
        System.out.println(offerProdName+" is extracted from Offer Page");
    }

    public void switchToOfferPage() {
        LandingPage landingPage = textContext.pageObjectManager.getLandingPage();
        landingPage.switchToOffersPage();
        textContext.genericUtils.switchWindowToChild();
    }

    @And("validate product name in offers page match with landing page")
    public void validateProductNameInOffersPageMatchWithLandingPage() {
        Assert.assertEquals(textContext.landingProdName,offerProdName);
    }
}
