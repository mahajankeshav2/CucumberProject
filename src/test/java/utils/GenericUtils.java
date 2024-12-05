package utils;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class GenericUtils {
    public WebDriver driver;

    public GenericUtils(WebDriver driver) {
        this.driver = driver;
    }
    public void switchWindowToChild()
    {
        Set<String> win= driver.getWindowHandles();
        Iterator<String> i1= win.iterator();
        String parentWindow=i1.next();
        String childWindow=i1.next();
        driver.switchTo().window(childWindow);
    }
}
