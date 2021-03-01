package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GooglePage extends AbstractPage {

    @FindBy(name = "q")
    private WebElement inputSearch;

    @FindBy(className = "LC20lb")
    private List<WebElement> result;

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public GooglePage openPage() {
        driver.get("https://www.google.com");
        return this;
    }

    public GooglePage search(String text) {
        inputSearch.sendKeys(text);
        inputSearch.sendKeys(Keys.ENTER);
        return this;
    }

    public boolean isNotEmpty() {
        return !result.isEmpty();
    }

    public YandexPage openFirstSite() {
        result.get(0).click();
        return new YandexPage(driver);
    }
}
