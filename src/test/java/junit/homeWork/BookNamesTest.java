package junit.homeWork;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class BookNamesTest {

    @BeforeEach
    void preconditions() {
        open("https://www.globalsqa.com/");
    }

    @AfterEach
    void closeBrowser() {
        closeWebDriver();
    }

    @ValueSource(strings = {"A Course in Machine Learning", "Advanced Machine Learning with Python", "Learning Generative Adversarial Networks "})
    @ParameterizedTest(name = "Search test for book \"{0}\"")
    void bookSearchTest(String bookName) {
        $("#menu-item-7128").hover();
        $("#menu-item-7132").click();
        $(".post-6932").shouldHave(text(bookName));
    }

}
