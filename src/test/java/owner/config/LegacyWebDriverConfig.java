package owner.config;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class LegacyWebDriverConfig {

    public Browser getBrowser() {
        String browser = System.getProperty("browser");
        if (Objects.isNull(browser)) {
            browser = "CHROME";
        }
        return Browser.valueOf(browser);
    }

    public String getBaseUrl() {
        String baseUrl = System.getProperty("baseUrl");
        if (Objects.isNull(baseUrl)) {
            baseUrl = "https://github.com";
        }
        return baseUrl;
    }

    public URL getRemoteUrl() {
        String remoteUrl = System.getProperty("remoteUrl");
        if (Objects.isNull(remoteUrl)) {
            remoteUrl = "https://selenium:444/wd/hub";
        }
        try {
            return new URL(remoteUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}