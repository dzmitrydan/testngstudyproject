package page;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$$;

public class YandexResultPage {

    private By result = By.className("serp-item");

    public boolean isNotEmpty() {
        return !$$(result).isEmpty();
    }
}
