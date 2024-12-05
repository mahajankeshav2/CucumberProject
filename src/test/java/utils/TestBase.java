package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;
    public WebDriver WebDriverManager() throws IOException
    {
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String url=prop.getProperty("url");
        String browser_prop=prop.getProperty("browser");
        String browser_maven=System.getProperty("browser");

        String browser=browser_maven==null?browser_prop:browser_maven;
        if (driver==null) {
            if(browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }
            if(browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();

            }
            if(browser.equals("ie")) {
                driver = new InternetExplorerDriver();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(url);

        }


        return driver;
    }
}
