package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegFormTestsWithPageObjectTests {

    RegistrationPage registrationPage = new RegistrationPage();

    //Test data
    String firstName = "Name";
    String lastName = "Last Name";
    String email = "Mail@mail.com";
    String gender = "Male";
    String userPhone = "1234567890";
    String subject = "Arts";
    String hobby = "Sports";
    String birthDateDay = "4";
    String birthDateMonth = "December";
    String birthDateYear = "1995";
    String birthDate = this.birthDateDay + " " + this.birthDateMonth + "," + this.birthDateYear;
    String address = "Moscow, Pushkin's house, Kolotushkina st";
    File picture = new File("src\\test\\resources\\cat.png");
    String state = "Haryana";
    String city = "Karnal";



    @BeforeAll
    static void BeforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void practiseForm() {

        //Fill forms
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(userPhone)
                .setBirthDate(birthDateYear, birthDateMonth, birthDateDay)
                .setSubject(subject)
                .setHobby(hobby)
                .setAddress(address)
                .uploadPicture(picture)
                .setState(state)
                .setCity(city)
                .submit();

        //Check results
        registrationPage
                .checkResults("Student Name", firstName + " " + lastName)
                .checkResults("Student Email", email)
                .checkResults("Gender", gender)
                .checkResults("Mobile", userPhone)
                .checkResults("Date of Birth", birthDate)
                .checkResults("Subjects", subject)
                .checkResults("Hobbies", hobby)
                .checkResults("Picture", picture.getName())
                .checkResults("Address", address)
                .checkResults("State and City", state + " " + city);

    }
}
