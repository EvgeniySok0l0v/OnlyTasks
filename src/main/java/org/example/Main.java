package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

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
    }

    /**
     * Method return unique words
     *
     * @param arr - input array of strings
     * @return - List of unique words
     */
    private static List<String> uniqueWords(String[] arr){
        return Arrays.stream(arr).distinct().collect(Collectors.toList());
    }

    /**
     * Method for count repetitions of string
     *
     * @param arr - input array of strings
     * @return - Map of words and repetitions
     */
    private static Map<String, Integer> countRepetitions(String[] arr){
        Map<String, Integer> repetitions = new HashMap<>();
        Arrays.stream(arr)
                .forEach(word -> repetitions.put(word, repetitions.containsKey(word) ? repetitions.get(word) + 1 : 1));
        return repetitions;
    }
}