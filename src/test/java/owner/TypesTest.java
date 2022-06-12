package owner;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import owner.config.TypesConfig;

import static org.assertj.core.api.Assertions.assertThat;

public class TypesTest {

    @Test
    public void testInteger() {
        System.setProperty("integer", "10");

        TypesConfig config = ConfigFactory.create(TypesConfig.class, System.getProperties());
        assertThat(config.getInteger()).isEqualTo(10);
    }


}
