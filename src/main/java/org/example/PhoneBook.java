package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class for PhoneBook
 */
public class PhoneBook {

    private static final Map<String,String> phoneBook = new HashMap<>(){
        {
            put("+375445976552", "Соколов");
            put("+375295976552", "Соколов");
            put("+375441234132", "Мурашко");
            put("+375445976553", "Мурашко");
            put("+375335956552", "Громыко");
        }
    };

    public PhoneBook() {
    }

    /**
     * Method for add number and last name to phone book
     *
     * @param number - phone number
     * @param lastName - last name
     */
    public static void add(String number, String lastName){
        phoneBook.put(number,lastName);
    }

    /**
     * Method to get info about user
     *
     * @param lastName - last name
     * @return - string
     */
    public static String get(String lastName){
        return new User(
                lastName,
                new ArrayList<>(phoneBook.entrySet().stream()
                        .filter(entry -> entry.getValue().equals(lastName))
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue
                        )).keySet())
                ).toString();
    }

    /**
     * Class for User
     */
    private static class User{

        private final String lastName;
        private final List<String> numbers;

        public User(String lastName, List<String> numbers) {
            this.lastName = lastName;
            this.numbers = numbers;
        }

        @Override
        public String toString() {
            return "User{" +
                    "lastName='" + lastName + '\'' +
                    ", numbers=" + numbers +
                    '}';
        }
    }
}
