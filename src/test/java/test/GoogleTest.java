package test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.GooglePage;
import page.YandexPage;

public class GoogleTest extends BaseTest {

    @Parameters({"param1"})
    @Test
    public void siteSearchTest(String param1) {
        System.out.println(driver);

        GooglePage googlePage = new GooglePage(driver).openPage().search(param1);
        YandexPage yandexPage = googlePage.openFirstSite();
        Assert.assertEquals(yandexPage.getUrl(), "https://yandex.by/");
    }

    @Parameters({"param1"})
    @Test
    public void searchTest(String param1) {
        System.out.println(driver);

        GooglePage googlePage = new GooglePage(driver).openPage().search(param1);
        Assert.assertTrue(googlePage.isNotEmpty());
    }
}
