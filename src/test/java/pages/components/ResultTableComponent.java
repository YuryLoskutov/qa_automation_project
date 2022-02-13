package pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {

    public ResultTableComponent checkTable(String label, String value) {
        $(".table")
                .shouldHave(Condition.text(label), Condition.text(value));

        return this;
    }
}
