package ownerHomeWork;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import ownerHomeWork.configHW.WebConfig;

import static org.assertj.core.api.Assertions.assertThat;

public class WebTest {
    @Test
    void remoteTest() {

        //./gradlew clean test -Dlaunch=remote
        System.setProperty("launch", "remote");

        WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

        assertThat(config.browserName()).isEqualTo("CHROME");
        assertThat(config.browserVersion()).isEqualTo("101.0");
        assertThat(config.launchType()).isEqualTo("https://user1:1234@selenoid.autotests.cloud/wd/hub/");
    }

    @Test
    void localTest() {

        //./gradlew clean test -Dlaunch=local
        System.setProperty("launch", "local");

        WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

        assertThat(config.browserName()).isEqualTo("CHROME");
        assertThat(config.browserVersion()).isEqualTo("101.0");
        assertThat(config.launchType()).isEqualTo("");
    }

}
