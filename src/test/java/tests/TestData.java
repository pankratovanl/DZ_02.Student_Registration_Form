package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

import static utils.RandomUtils.*;

public class TestData {
    public static Faker faker = new Faker(new Locale("eng"));
    public static String
            pageName = "Practice Form",
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            sex = "Male",
            phone = faker.phoneNumber().subscriberNumber(10),
            subject = "Arts",
            hobbies = "Music",
            fileNameLocation = "img/familyguy (2).png",
            fileName = "familyguy (2).png",
            currentAddress = faker.address().fullAddress(),
            state = "NCR",
            city = "Delhi";

}
