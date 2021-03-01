package driver;

import com.google.inject.AbstractModule;
import org.openqa.selenium.WebDriver;

public class ParentModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(WebDriver.class).toInstance(new WebDriverProvider().getDriver());
    }
}
