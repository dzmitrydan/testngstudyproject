package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.support.FindBy;

public class GoogleResultPage {

    @FindBy(className = "LC20lb")
    private ElementsCollection result;

    public YandexSearchPage openFirstSite() {
        result.first().click();
        return Selenide.page(YandexSearchPage.class);
    }

    public ElementsCollection getResult() {
        return result;
    }
}
