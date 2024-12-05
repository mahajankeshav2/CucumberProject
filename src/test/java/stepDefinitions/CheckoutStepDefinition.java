package stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckoutStepDefinition {
    public WebDriver driver;
    TestContextSetup textContext;
    CheckoutPage checkoutPage;

    public CheckoutStepDefinition(TestContextSetup textContext) {
        this.textContext=textContext;
        checkoutPage= textContext.pageObjectManager.getCheckoutPage();
    }

    @Then("^user proceeds to Checkout and validate the (.+) items in checkout page$")
    public void user_proceeds_to_checkout_and_validate_the_tom_items_in_checkout_page(String itemName) {
        checkoutPage.CheckOutItems();
        Assert.assertEquals(textContext.landingProdName,checkoutPage.getProductName().split("-")[0].trim());
    }
    @Then("verify user has ability to enter promo code and place the order")
    public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(checkoutPage.VerifyPromoButton());
        Assert.assertTrue(checkoutPage.VerifyPlaceOrderButton());

    }
}
