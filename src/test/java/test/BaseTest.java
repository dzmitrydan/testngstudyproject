package test;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import driver.GuiceDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    final Injector injector = Guice.createInjector(new GuiceDriverManager());

    @Inject
    WebDriver driver;

    @BeforeMethod
    public void prepareToTest() {
    }

    @AfterMethod
    public void tearDownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
