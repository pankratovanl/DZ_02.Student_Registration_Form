package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class RegistrationFormWithTestBaseTests extends TestBase {

    @Test
    void FillFormTest() {

        open("/automation-practice-form");

        //заполнение формы
        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue("Yuriy");
        $("#lastName").setValue("Gagarin");
        $("#userEmail").setValue("gagarin@comp.ru");
        $(byText("Male")).click();
        $("#userNumber").setValue("2121212121");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("2");
        $(".react-datepicker__year-select").selectOptionByValue("1934");
        $(".react-datepicker__day--009").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/familyguy (2).png");
        $("#currentAddress").setValue("Address and street 1");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        //проверка заполненной формы на валидность
        $(".table-responsive").shouldHave(
                text("Yuriy Gagarin"),
                text("gagarin@comp.ru"),
                text("Male"),
                text("2121212121"),
                text("09 March,1934"),
                text("Arts"),
                text("Music"),
                text("familyguy (2).png"),
                text("Address and street 1"),
                text("NCR Delhi")
        );

    }
}