package tests;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.RandomUtils.getRandomString;

public class RegFormTestsWithRandom extends TestBase {

    String firstName = getRandomString(10);
    String lastName = getRandomString(10);

    @Test
    void practiseForm() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue("Mail@mail.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1995");
        $(".react-datepicker__month-select").selectOptionContainingText("December");
        $(".react-datepicker__day--004").click();

        $("#subjectsInput").setValue("Art").pressEnter();

        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();

        //Загрузить файл можно еще вот так (но лучше не надо):
        //$("#uploadPicture").uploadFile(new File("src\\test\\resources\\cat.png"));
        File cat = new File("src\\test\\resources\\cat.png");
        $("#uploadPicture").uploadFile(cat);

        $("#currentAddress").setValue("Moskow, Pushkin's house, Kolotushkina st");

        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();

        $("#submit").scrollTo().click();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName + " " + lastName),
                text("Mail@mail.com"),
                text("Male"),
                text("1234567890"),
                text("04 December,1995"),
                text("Arts"),
                text("Sports, Reading, Music"),
                text("cat.png"),
                text("Moskow, Pushkin's house, Kolotushkina st"),
                text("Haryana Karnal"));
    }
}
