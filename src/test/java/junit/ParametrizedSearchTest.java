package junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ParametrizedSearchTest {

    @BeforeEach
    void precondition() {
        open("https://ya.ru/");
    }

    @AfterEach
    void closeBrowser() {
        closeWebDriver();
    }

    @ValueSource(strings = {"Selenide", "Junit 5"})
    @ParameterizedTest (name = "Check {0}")
    void commonSearchTest(String testData) {
        $("#text").setValue(testData);
        $(".search2__button").click();
        $$("li.serp-item").find(text(testData)).shouldBe(visible);
    }

    @CsvSource({
            "Selenide, concise UI tests in Java",
            "Junit 5, IntelliJ IDEA"
    })
    @ParameterizedTest (name = "Check {0}")
    void complexSearchTest(String testData, String expectedText) {
        $("#text").setValue(testData);
        $(".search2__button").click();
        $$("li.serp-item").find(text(expectedText)).shouldBe(visible);
    }

    @MethodSource
    @ParameterizedTest
    void mixedArgumentsTest() {

    }

}