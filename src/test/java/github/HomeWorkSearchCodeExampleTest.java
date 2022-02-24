package github;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class HomeWorkSearchCodeExampleTest {

    //Есть ли разница между $("h1 div"); и $("h1").$("div"); - может ли привести к тому что, поиск найдёт разные элементы?
    //Если может - приведите пример, когда.

    // $("h1 div") ищет div во всех h1
    // $("h1").$("div") - ищет первый h1, а потом внутри него div
    // То есть в случае, если в дереве есть два h1, а div в одном из них, то первый вариант найдет этот элемент,
    // а второй найдёт только в том случае, если в первом h1 есть div

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

    @Test
    void dragAndDropTest () {

        // Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");

        // Перенесите прямоугольник А на место В
        $("#column-a").dragAndDropTo($("#column-b"));

        // Проверьте, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

    }
}
