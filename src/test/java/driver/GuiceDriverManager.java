package driver;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import org.openqa.selenium.WebDriver;


public class GuiceDriverManager extends AbstractModule {

    @Override
    protected void configure() {
        bind(DriverInterface.class).toProvider(WebDriverProvider.class).in(Scopes.SINGLETON);
    }

    @Provides
    public WebDriver getDriver(DriverInterface driverManager) {
        return driverManager.setupDriver();
    }
}
