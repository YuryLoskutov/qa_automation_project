package ownerHomeWork.configHW;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:homeWork/${launch}.properties"
})

public interface WebConfig extends Config {

    @Key("browser.name")
    String browserName();

    @Key("browser.version")
    String browserVersion();

    @Key("launch.type")
    String launchType();


}
