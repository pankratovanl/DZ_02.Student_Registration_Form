package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    // locators

    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement resultTable = $(".table-responsive");

    //actions

    public void setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

    }

    public void setLastName(String lastName) {
        lastNameInput.setValue(lastName);

    }

    public void checkForm(String fieldName, String value) {
        resultTable.$(byText(fieldName))
                .parent().shouldHave(text(value));

    }
}
