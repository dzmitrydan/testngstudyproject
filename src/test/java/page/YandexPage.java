package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class YandexPage extends AbstractPage {

    @FindBy(id = "text")
    private WebElement inputSearch;

    @FindBy(className = "OrganicTitle-LinkText")
    private List<WebElement> result;

    public YandexPage(WebDriver driver) {
        super(driver);
    }

    public YandexPage openPage() {
        driver.get("https://yandex.by/");
        return this;
    }

    public YandexPage search(String text) {
        inputSearch.sendKeys(text);
        inputSearch.sendKeys(Keys.ENTER);
        return this;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isNotEmpty() {
        return !result.isEmpty();
    }
}
