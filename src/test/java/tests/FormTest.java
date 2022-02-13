package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class FormTest {

    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void FillFormTest() {

        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue("Yuriy");
        $("#lastName").setValue("Gagarin");
        $("#userEmail").setValue("gagarin@comp.ru");
        $(byText("Male")).click();
        $("#userNumber").setValue("21212121");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("2");
        $(".react-datepicker__year-select").selectOptionByValue("1934");
        $(".react-datepicker__day--009").click();
        $("#subjectsInput").setValue("Space travel").pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("familyguy (2).png");
        $("#currentAddress").setValue("Address and street 1");
        $("react-select-3-input").selectOptionByValue("Rajastan");
        $("react-select-4-input").selectOptionByValue("Jaipur");
        $("#submit").click();

        $("#output").shouldHave(text("Gagarin"), text("gagarin@comp.ru"),
                text("Address and street 1"), text("Address and building 2"));

    }
}