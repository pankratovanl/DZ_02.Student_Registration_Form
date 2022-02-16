package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class RegistrationFormWithPageObjectsTests {

    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void FillFormTest() {

        open("/automation-practice-form");

        //заполнение формы
        $(".main-header").shouldHave(text("Practice Form"));

        new RegistrationPage().setFirstName("Yuriy");
        new RegistrationPage().setLastName("Gagarin");
        $("#userEmail").setValue("gagarin@comp.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("2121212121");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("2");
        $(".react-datepicker__year-select").selectOptionByValue("1934");
        $(".react-datepicker__day--009").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/familyguy (2).png");
        $("#currentAddress").setValue("Address and street 1");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").scrollTo().click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();

        //проверка заполненной формы на валидность
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        new RegistrationPage().checkForm("Student Name","Yuriy Gagarin");
        new RegistrationPage().checkForm("Student Email","gagarin@comp.ru");
        new RegistrationPage().checkForm("Gender","Male");
        new RegistrationPage().checkForm("Mobile","2121212121");

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