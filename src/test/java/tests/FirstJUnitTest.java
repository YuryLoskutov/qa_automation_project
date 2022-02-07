package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import net.jodah.failsafe.internal.util.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FirstJUnitTest {

    @BeforeEach
    void openBrowser() {
        Configuration.browser = "firefox";
        Selenide.open("https://yandex.ru");
    }

    @AfterEach
    void closeBrowser(){
        Configuration.browser = "firefox";
        Selenide.closeWebDriver();
    }

    @Test
    void simpleTest() {
        Assertions.assertTrue(2 < 3 );
    }
}
