package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private By addToCart = By.cssSelector("[alt='Cart']");
    private By checkOutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
    private By promoButton= By.cssSelector(".promoBtn");
    private By placeOrderButton = By.xpath("//button[contains(text(),'Place Order')]");
    private By productName= By.xpath("//p[@class='product-name']");
    WebDriver driver;

    public CheckoutPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void CheckOutItems()
    {
        driver.findElement(addToCart).click();
        driver.findElement(checkOutButton).click();
    }
    public Boolean VerifyPromoButton()
    {
        return driver.findElement(promoButton).isDisplayed();
    }
    public Boolean VerifyPlaceOrderButton()
    {
        return driver.findElement(placeOrderButton).isDisplayed();
    }
    public String getProductName()
    {
        return driver.findElement(productName).getText();
    }
}
