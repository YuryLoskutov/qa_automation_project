package github;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class MainContributorTest {

    @Test
    void andrejSolntsevShouldBeTheMainContributor() {
        // открыть страничку
        open("https://github.com/selenide/selenide");
        // навести мышку на элемент
        $(".Layout-sidebar").$(withText("Contributors")).
                closest(".BorderGrid-row").$("ul li").hover();
        // проверить, что там Andrei Solntsev
        $$(".Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));

    }
}
