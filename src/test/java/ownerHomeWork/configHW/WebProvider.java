package ownerHomeWork.configHW;

import org.aeonbits.owner.ConfigFactory;

public class WebProvider {

    public static WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());

    public static boolean isRemoteWebDriver() {
        return !webConfig.launchType().equals("");
    }
}
