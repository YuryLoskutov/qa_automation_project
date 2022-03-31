package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

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
    @Disabled
    void simpleTest() {
        Assertions.assertTrue(2 < 3);
    }
}
