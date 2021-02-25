package driver;

import com.google.inject.Provider;

public class WebDriverProvider implements Provider<DriverInterface> {

    private static String webBrowser;

    public static void setWebBrowser(String string) {
        webBrowser = string;
    }

    @Override
    public DriverInterface get() {

        if (webBrowser.equals("chrome")) {
            return new ChromeDriverManager();
        }
        else {
            return new FirefoxDriverManager();
        }
    }
}
