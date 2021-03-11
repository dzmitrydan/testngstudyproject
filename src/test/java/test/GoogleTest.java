package test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.GoogleResultPage;
import page.GoogleSearchPage;
import page.YandexSearchPage;

import java.lang.reflect.Method;

public class GoogleTest extends BaseTest {

    @Parameters({"param1"})
    @Test
    public void siteSearchTest(String param1) {
        Method[] methods = getClass().getMethods();
        System.out.println(methods[0] + " : " + param1);

        GoogleResultPage googleResultPage = new GoogleSearchPage().openPage().search(param1);
        YandexSearchPage yandexSearchPage = googleResultPage.openFirstSite();
        Assert.assertEquals(yandexSearchPage.getUrl(), "https://yandex.by/");
    }

    @Parameters({"param1"})
    @Test
    public void searchTest(String param1) {
        Method[] methods = getClass().getMethods();
        System.out.println(methods[1] + " : " + param1);

        GoogleResultPage googleResultPage = new GoogleSearchPage().openPage().search(param1);
        Assert.assertTrue(googleResultPage.getResult().isEmpty());
    }

}
