package utils;

import com.github.javafaker.Faker;

public class FakeMessageGenerator {


    public static String generateName() {
        return new Faker().name().firstName();
    }


    public static String generateSurname() {
        return new Faker().name().lastName();
    }

    public static String generatePassword() {
        return new Faker().random().toString();
    }

    public static String generateEmail() {
        return new Faker().internet().emailAddress();
    }
}
