package ownerHomeWork.configHW;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:/tmp/secret.properties",
        "classpath:homeWork/token.properties"
})

public interface TokenConfig extends Config {

    @Key("token")
    String token();

}
