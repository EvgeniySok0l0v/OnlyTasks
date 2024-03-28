package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {

        //Task1
        logger.info("Task 1 result:");
        Tasks.printThreeWords();
        //Task2
        logger.info("Task 2 result:");
        Tasks.checkSumSign();
        //Task3
        logger.info("Task 3 result:");
        Tasks.printColor();
        //Task4
        logger.info("Task 4 result:");
        Tasks.compareNumbers();
        //Task5
        logger.info("Task 5 result:");
        logger.info(Boolean.toString(Tasks.checkRangeTenToTwenty(1, 10)));
        //Task 6
        logger.info("Task 6 result:");
        Tasks.checkNumber(-1);
        //Task 7
        logger.info("Task 7 result:");
        logger.info(Boolean.toString(Tasks.isNegative(1)));
        //Task 8
        logger.info("Task 8 result:");
        Tasks.printStrings(2,"xyz");
        //Task 9
        logger.info("Task 9 result:");
        logger.info(Boolean.toString(Tasks.isLeapYear(2022)));
        //Task 10
        logger.info("Task 10 result:");
        logger.info(Arrays.toString(Tasks.changeValues(new int[]{1,0,1,0,1,1,1,0})));
        //Task 11
        logger.info("Task 11 result:");
        logger.info(Arrays.toString(Tasks.fillArray()));
        //Task 12
        logger.info("Task 12 result:");
        logger.info(Arrays.toString(Tasks.multiNumberLessSix()));
        //Task 13
        logger.info("Task 13 result:");
        for(int[] arr : Tasks.fillDiagonals(10)){
            logger.info(Arrays.toString(arr));
        }
        //Task 14
        logger.info("Task 14 result:");
        logger.info(Arrays.toString(Tasks.initialArr(3,7)));
    }
}













