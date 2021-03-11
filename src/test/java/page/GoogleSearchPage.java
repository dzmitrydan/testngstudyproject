package page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GoogleSearchPage {

    @FindBy(how = How.NAME, using = "q")
    private SelenideElement inputSearch;

    public GoogleSearchPage openPage() {
        Selenide.open("https://www.google.com");
        return this;
    }

    public GoogleResultPage search(String text) {
        inputSearch.setValue(text).pressEnter();
        return Selenide.page(GoogleResultPage.class);
    }
}
