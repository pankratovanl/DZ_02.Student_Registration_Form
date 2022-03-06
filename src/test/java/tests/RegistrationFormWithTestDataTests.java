package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.TestData.*;


public class RegistrationFormWithTestDataTests extends TestBase {

    @Test
    void FillFormTest() {

        open("/automation-practice-form");

        //заполнение формы
        $(".main-header").shouldHave(text(pageName));
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(byText(sex)).click();
        $("#userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("2");
        $(".react-datepicker__year-select").selectOptionByValue("1934");
        $(".react-datepicker__day--009").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $(byText(hobbies)).click();
        $("#uploadPicture").uploadFromClasspath(fileNameLocation);
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();

        //проверка заполненной формы на валидность
        $(".table-responsive").shouldHave(
                text(firstName + " " + lastName),
                text(email),
                text(sex),
                text(phone),
                text("09 March,1934"),
                text(subject),
                text(hobbies),
                text(fileName),
                text(currentAddress),
                text(state + " " + city)
        );

    }
}