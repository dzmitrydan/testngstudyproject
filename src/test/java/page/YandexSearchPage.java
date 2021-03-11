package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class YandexSearchPage {

    private By inputSearch = By.id("text");

    public YandexSearchPage openPage() {
        Selenide.open("https://yandex.by/");
        return this;
    }

    public YandexResultPage search(String text) {
        $(inputSearch).val(text);
        $(inputSearch).pressEnter();
        return new YandexResultPage();
    }

    public String getUrl() {
        return WebDriverRunner.url();
    }

}
