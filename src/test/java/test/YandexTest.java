package test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.YandexPage;

import java.lang.reflect.Method;

public class YandexTest extends BaseTest implements TestInterface {

    @Parameters({"param1", "param2"})
    @Test
    public void openPageTest(String param1, String param2) {
        System.out.println(driver);
        System.out.println("param1: " + param1 + "; param2: " + param2);

        Method[] methods = getClass().getMethods();
        System.out.println(methods[0] + " : " + param1 + " : " + param2);

        YandexPage yandexPage = new YandexPage(driver).openPage();
        Assert.assertEquals(yandexPage.getUrl(), "https://yandex.by/");
    }

    @Parameters({"param1"})
    @Test
    public void searchTest(String param1) {
        System.out.println(driver);

        Method[] methods = getClass().getMethods();
        System.out.println(methods[1] + " : " + param1);

        YandexPage yandexPage = new YandexPage(driver).openPage().search(param1);
        Assert.assertTrue(yandexPage.isNotEmpty());
    }
}
