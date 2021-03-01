package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverProvider {

    private WebDriver driver;
    private static String webBrowser = "chrome";

    public WebDriver getDriver() {
        switch (webBrowser) {
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            }
            default: {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
        }
        return driver;
    }
}
