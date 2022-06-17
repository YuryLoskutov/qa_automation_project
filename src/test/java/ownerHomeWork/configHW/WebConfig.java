package ownerHomeWork.configHW;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:homeWork/${launch}.properties"
})

public interface WebConfig extends Config {

    @Key("browser_name")
    String browserName();

    @Key("browser_version")
    String browserVersion();

    @Key("launch_type")
    String launchType();

}
