package junit.homeWork;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class GoogleTransRusEndTest {

    //Тест кейс 1: проверка на соотвествие пререводов с русского на английский в google переводчике

    @BeforeEach
    void precondition() {
        open("https://translate.google.com/?sl=ru&tl=en&op=translate");
    }

    @AfterEach
    void closeBrowser() {
        closeWebDriver();
    }

    @CsvSource(value = {
            "Тест перевода| Test translation",
            "Привет, мир| Hello world"
    },
    delimiter = '|'
    )
    @ParameterizedTest(name = "Rus-Eng translation smoke test of {0}")
    void googleTransRusEngSmokeTest(String rusText, String expectedEngTrans) {
        $(".er8xn").setValue(rusText);
        $(".P6w8m").shouldHave(text(expectedEngTrans));
    }
}