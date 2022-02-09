package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTest {

    @BeforeAll
    static void BeforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }


    //Дом задание 2
    @Test
    void practiseForm() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue("Name");
        $("#lastName").setValue("Last Name");
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

        File cat = new File("src\\test\\resources\\cat.png");
        $("#uploadPicture").uploadFile(cat);

        $("#currentAddress").setValue("Moskow, Pushkin's house, Kolotushkina st");

        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();

        $("#submit").click();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Name Last Name"));
        $(".table-responsive").shouldHave(text("Mail@mail.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("1234567890"));
        $(".table-responsive").shouldHave(text("04 December,1995"));
        $(".table-responsive").shouldHave(text("Arts"));
        $(".table-responsive").shouldHave(text("Sports, Reading, Music"));
        $(".table-responsive").shouldHave(text("cat.png"));
        $(".table-responsive").shouldHave(text("Moskow, Pushkin's house, Kolotushkina st"));
        $(".table-responsive").shouldHave(text("Haryana Karnal"));


    }
}
