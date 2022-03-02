package junit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Class with simple")
public class SimpleTest {

    @Test
    @DisplayName("Expect green test")
    void simpleGreenTest() {
        assertTrue(3 > 2);
    }

    @Test
    @DisplayName("Expect red test")
    void simpleRedTest() {
        assertTrue(3 < 2);
    }

    @Test
    @Disabled("disabled")
    void simpleBrokenTest() {
        throw new IllegalStateException("Broken :(");
    }

}
