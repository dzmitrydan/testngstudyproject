package page;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GooglePage {

    private By inputSearch = By.name("q");
    private By result = By.className("LC20lb");

    public GooglePage openPage() {
        Selenide.open("https://www.google.com");
        return this;
    }

    public GooglePage search(String text) {
        $(inputSearch).setValue(text);
        $(inputSearch).pressEnter();
        return this;
    }

    public boolean isNotEmpty() {
        return $(result).isDisplayed();
    }

    public YandexPage openFirstSite() {
        $$(result).first().click();
        return new YandexPage();
    }

}
