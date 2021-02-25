package test;

import driver.WebDriverProvider;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.GooglePage;

public class GoogleTest extends BaseTest {

    @Parameters({"param1"})
    @Test
    public void openGoogleTest(String param1) {
        WebDriverProvider.setWebBrowser(param1);
        injector.injectMembers(this);
        GooglePage googlePage = new GooglePage(driver);
        googlePage.openPage();
        System.out.println("Execute test on " + param1);
        Assert.assertEquals(googlePage.getUrl(), "https://www.google.com/");
    }
}
