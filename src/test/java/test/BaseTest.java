package test;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    @BeforeClass
    public void setUp() {
        Configuration.browser = Browsers.FIREFOX;
    }
}
