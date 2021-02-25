package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {

    private final WebDriver driver;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GooglePage openPage() {
        driver.get("https://www.google.com");
        return this;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
