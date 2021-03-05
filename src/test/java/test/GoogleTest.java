package test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.GooglePage;
import page.YandexPage;

import java.lang.reflect.Method;

public class GoogleTest extends BaseTest implements TestInterface {

    @Parameters({"param1"})
    @Test
    public void siteSearchTest(String param1) {
        System.out.println(driver);

        Method[] methods = getClass().getMethods();
        System.out.println(methods[0] + " : " + param1);

        GooglePage googlePage = new GooglePage(driver).openPage().search(param1);
        YandexPage yandexPage = googlePage.openFirstSite();
        Assert.assertEquals(yandexPage.getUrl(), "https://yandex.by/");
    }

    @Parameters({"param1"})
    @Test
    public void searchTest(String param1) {
        System.out.println(driver);

        Method[] methods = getClass().getMethods();
        System.out.println(methods[1] + " : " + param1);

        GooglePage googlePage = new GooglePage(driver).openPage().search(param1);
        Assert.assertTrue(googlePage.isNotEmpty());
    }

    public void search(String string) {
        System.out.println("Search: " + string);
    }
}
