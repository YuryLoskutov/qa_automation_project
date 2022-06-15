package ownerHomeWork.configHW;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:homeWork/api.properties"
})

public interface ApiConfig extends Config{

    @Key("baseUrl")
    @DefaultValue("https://demoqa.com/")
    String baseUrl();

}
