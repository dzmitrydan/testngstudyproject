package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class YandexPage {

    private By inputSearch = By.id("text");
    private By result = By.className("OrganicTitle-LinkText");


    public YandexPage openPage() {
        Selenide.open("https://yandex.by/");
        return this;
    }

    public YandexPage search(String text) {
        $(inputSearch).val(text);
        $(inputSearch).pressEnter();
        return this;
    }

    public String getUrl() {
        return WebDriverRunner.url();
    }

    public boolean isNotEmpty() {
        return !$$(result).isEmpty();
    }
}
