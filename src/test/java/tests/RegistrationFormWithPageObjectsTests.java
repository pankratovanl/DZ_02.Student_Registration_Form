package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormWithPageObjectsTests {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Yuriy";
    String lastName = "Gagarin";
    String userEmail = "gagarin@comp.ru";
    String gender = "Male";
    String userNumber = "2121212121";
    String year = "1934";
    String month = "March";
    String day = "9";
    String subjects = "Arts";
    String hobbies = "Music";
    String picture = "img/familyguy (2).png";
    String currentAddress = "Address and street 1";
    String state = "NCR";
    String city = "Noida";


    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void FillFormTest() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDate(day, month, year)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(picture)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submitForm();


               //проверка заполненной формы на валидность
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        registrationPage
                .checkForm("Student Name", firstName + " Gagarin")
                .checkForm("Student Email", "gagarin@comp.ru")
                .checkForm("Gender", "Male")
                .checkForm("Mobile", "2121212121");

        $(".table-responsive").$(byText("Date of Birth"))
                .parent().shouldHave(text("09 March,1934"));
        $(".table-responsive").$(byText("Subjects"))
                .parent().shouldHave(text("Arts"));
        $(".table-responsive").$(byText("Hobbies"))
                .parent().shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture"))
                .parent().shouldHave(text("familyguy (2).png"));
        $(".table-responsive").$(byText("Address"))
                .parent().shouldHave(text("Address and street 1"));
        $(".table-responsive").$(byText("State and City"))
                .parent().shouldHave(text("NCR Noida"));

    }
}