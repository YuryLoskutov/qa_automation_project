package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class HomeWorkSearchCodeExampleTest {

    @Test
    void HomeWorkSearchCodeExampleTest() {

        //Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");

        //Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();


        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $(".wiki-pages-box").$(byTagName("button")).click();
        $(".wiki-pages-box").shouldHave(text("SoftAssertions"));

        //Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $(byText("SoftAssertions")).click();
        $$("ol").findBy(text("Using JUnit5 extend test class")).sibling(0)
                .shouldHave(text("class Tests"));

    }
}
