package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    //components
    private CalendarComponent calendarComponent = new CalendarComponent();

    // locators

    private SelenideElement
            headerTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            birthDateInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitForm = $("#submit"),

    resultsTable = $(".table-responsive");

    //actions

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Student Registration Form"));

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

    public RegistrationPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);

        return this;
    }

    public RegistrationPage setGender(String gender) {
        genderInput.$(byText(gender)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);

        return this;
    }


    public RegistrationPage setBirthDate(String day, String month, String year) {
        $(birthDateInput).click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();

        return this;

    }

    public RegistrationPage setHobbies(String hobbies) {
        $(byText(hobbies)).click();

        return this;

    }

    public RegistrationPage setPicture(String picture) {
        pictureInput.uploadFromClasspath(picture);

        return this;

    }

    public RegistrationPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);

        return this;

    }

    public RegistrationPage setState(String state) {
        stateInput.scrollTo().click();
        $(byText(state)).click();

        return this;

    }

    public RegistrationPage setCity(String city) {
        cityInput.scrollTo().click();
        $(byText(city)).click();

        return this;

    }

    public RegistrationPage submitForm() {
        submitForm.click();

        return this;
    }


    public RegistrationPage checkForm(String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));

        return this;

    }
}
