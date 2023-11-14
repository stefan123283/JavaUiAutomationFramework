package com.opencart.managers;

public class DataSubstituteManager {
    public static String substituteString(String value) {
        switch (value.toUpperCase()) {
            case "RANDOM":
                return RandomDataManager.generateLastName();
            case "RANDOMEMAIL":
                return RandomDataManager.generateRandomEmail();
            case "RANDOMFIRSTNAME":
                return RandomDataManager.generateFirstName();
            case "RANDOMPASSWORD":
                return RandomDataManager.generatePassword();

        }
        return value;
    }
}
