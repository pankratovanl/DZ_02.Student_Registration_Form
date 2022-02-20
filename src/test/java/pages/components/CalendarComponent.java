package pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDate(String day, String month, String year) {
        $(".react-datepicker-popper").should(Condition.appear);
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day + "").click();

    }

}
