package test;

import com.google.inject.Inject;
import driver.ParentModule;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Guice(modules = {ParentModule.class})
public class BaseTest {

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
