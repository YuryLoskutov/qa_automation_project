package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTest {

    @BeforeAll
    static void BeforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        open("/text-box");
        $(".main-header").shouldHave(text("Text Box"));

        $("#userEmail").setValue("Yury@kkk.com");
        $("#userName").setValue("YuryL");
        $("#currentAddress").setValue("CAddress");
        $("#permanentAddress").setValue("PAddress");
        $("#submit").click();

        $("#output").shouldHave(text("YuryL"), text("Yury@kkk.com"), text("CAddress"),text("PAddress"));



    }
}
