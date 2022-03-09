package junit.homeWork;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegFormParamTest {

    @BeforeEach
    void precon() {
        Configuration.browserSize = "1920x1080";
        open("https://demoqa.com/automation-practice-form");
    }

    @AfterEach
    void closeBrowser() {
        closeWebDriver();
    }

    static Stream<Arguments> testDataProvider () {
        return Stream.of(
                Arguments.of("Ivan", "Ivanov", "1234567890"),
                Arguments.of("Pyotr", "Petrov", "1233456789")
        );
    }

    @MethodSource(value = "testDataProvider")
    @ParameterizedTest(name = "Check registration form")
    void regFormTest(String name, String lastName, String number) {
        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);
        $(byText("Male")).click();
        $("#userNumber").setValue(number);

        $("#submit").scrollTo().click();
        $(".table-responsive").shouldHave(text(name + " " + lastName),
                text("Male"),
                text(number));

    }
}
