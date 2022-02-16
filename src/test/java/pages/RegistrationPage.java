package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    //components
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultTableComponent resultTableComponent = new ResultTableComponent();

    // locators
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            gender = $(".practice-form-wrapper #genterWrapper"),
            userPhoneInput = $("#userNumber"),
            birthDateInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbyInput = $(".practice-form-wrapper #hobbiesWrapper"),
            pictureUploadInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submit = $("#submit");

    // actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }


    public RegistrationPage setBirthDate(String year, String month, String day) {
        birthDateInput.click();
        calendarComponent.setDate(year, month, day);

        return this;
    }


    public RegistrationPage setEmail(String email) {
        emailInput.setValue(email);

        return this;
    }

    public  RegistrationPage setGender(String gender) {
        this.gender
                .$(byText(gender))
                .click();

        return this;
    }

    public RegistrationPage setPhone(String phone) {
        userPhoneInput.setValue(phone);

        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectInput.setValue(subject)
                .pressEnter();

        return this;
    }

    public RegistrationPage setHobby(String hobby) {
        hobbyInput.$(byText(hobby))
                .click();

        return this;
    }

    public RegistrationPage uploadPicture (File picture) {
        pictureUploadInput.uploadFile(picture);

        return this;
    }

    public RegistrationPage setAddress(String address) {
        currentAddressInput.setValue(address);

        return this;
    }

    public RegistrationPage setState(String state) {
        stateInput.setValue(state).pressEnter();

        return this;
    }

    public RegistrationPage setCity(String city) {
        cityInput.setValue(city).pressEnter();

        return this;
    }

    public RegistrationPage submit() {
        submit.scrollTo().click();

        return this;
    }

    public RegistrationPage checkResults (String label, String value) {
        resultTableComponent.checkTable(label, value);

        return this;
    }


}