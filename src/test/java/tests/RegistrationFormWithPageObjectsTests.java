package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

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
    String pictureName = "familyguy (2).png";
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

        registrationPage
                .checkForm("Student Name", firstName + " " + lastName)
                .checkForm("Student Email", userEmail)
                .checkForm("Gender", gender)
                .checkForm("Mobile", userNumber)
                .checkForm("Date of Birth", day + " " + month + "," + year)
                .checkForm("Subjects", subjects)
                .checkForm("Hobbies", hobbies)
                .checkForm("Picture", pictureName)
                .checkForm("Address", currentAddress)
                .checkForm("State and City", state + " " + city);

    }
}