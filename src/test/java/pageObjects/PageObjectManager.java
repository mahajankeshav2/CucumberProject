package pageObjects;

import org.openqa.selenium.WebDriver;
import utils.GenericUtils;

public class PageObjectManager {
    private LandingPage landingPage;
    private WebDriver driver;
    private  OfferPage offerPage;
    private CheckoutPage checkoutPage;
    private  GenericUtils genericUtils;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPage getLandingPage(){
        landingPage= new LandingPage(driver);
        return landingPage;
    }

    public OfferPage getOfferPage(){
        offerPage= new OfferPage(driver);
        return offerPage;
    }
    public CheckoutPage getCheckoutPage(){
        checkoutPage= new CheckoutPage(driver);
        return checkoutPage;
    }

}
