package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.example.Words.countRepetitions;
import static org.example.Words.uniqueWords;


public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private static final String[] words = new String[]{
            "кот","пес","собака","Арнольд","Arnold",
            "кот","лис","Собчак","крокодил","Китай",
            "лис","пес","музыка","Арнольд","фильмы",
            "пес","лис","cat","Кот","Ford Focus",
    };
    public static void main(String[] args) {

        logger.info(uniqueWords(words).toString());
        logger.info(countRepetitions(words).toString());

        PhoneBook.add("+375331234567", "Соколов");
        logger.info(PhoneBook.get("Соколов"));
    }
}