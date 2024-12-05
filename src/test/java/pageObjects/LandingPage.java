package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.TestContextSetup;

public class LandingPage {
    private By search = By.xpath("//input[@type='search']");
    private By productName = By.cssSelector("h4.product-name");
    private By topDeals = By.linkText("Top Deals");
    private By increment= By.cssSelector("a.increment");
    private By addToCartButton= By.cssSelector(".product-action button");
    WebDriver driver;

    public LandingPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void searchItem(String shortName)
    {
        driver.findElement(search).sendKeys(shortName);
    }
    public String getProductName()
    {
        return driver.findElement(productName).getText();
    }
    public void switchToOffersPage()
    {
        driver.findElement(topDeals).click();
    }

    public void incrementItem(int quantity)
    {
        for(int i=1;i<quantity;i++)
        {
            driver.findElement(increment).click();
        }
    }
    public void clickAddToCart()
    {
        driver.findElement(addToCartButton).click();
    }

}
