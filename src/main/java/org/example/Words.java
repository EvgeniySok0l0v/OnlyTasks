package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class fow Words
 */
public class Words {

    public Words() {
    }

    /**
     * Method return unique words
     *
     * @param arr - input array of strings
     * @return - List of unique words
     */
    public static List<String> uniqueWords(String[] arr){
        return Arrays.stream(arr).distinct().collect(Collectors.toList());
    }

    /**
     * Method for count repetitions of string
     *
     * @param arr - input array of strings
     * @return - Map of words and repetitions
     */
    public static Map<String, Integer> countRepetitions(String[] arr){
        Map<String, Integer> repetitions = new HashMap<>();
        Arrays.stream(arr)
                .forEach(word -> repetitions.put(word, repetitions.containsKey(word) ? repetitions.get(word) + 1 : 1));
        return repetitions;
    }
}
