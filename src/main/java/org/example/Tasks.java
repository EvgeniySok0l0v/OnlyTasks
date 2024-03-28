package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tasks {

    private static final Logger logger = LoggerFactory.getLogger(Tasks.class);

    public Tasks() {
    }

    /**
     * 1. Создайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова:
     * Orange, Banana, Apple.
     */
    public static void printThreeWords() {
        logger.info("\nOrange,\nBanana,\nApple.");
    }

    /**
     * 2. Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b,
     *  и инициализируйте их любыми значениями, которыми захотите. Далее метод должен просуммировать эти переменные,
     *  и если их сумма больше или равна 0, то вывести в консоль сообщение “Сумма положительная”,
     *  в противном случае - “Сумма отрицательная”;
     */
    public static void checkSumSign() {
        int a = 8;
        int b = 7;

        if(a + b >= 0)
            logger.info("Сумма положительная");
        else
            logger.info("Сумма отрицательная");
    }

    /**
     * 3. Создайте метод printColor() в теле которого задайте int переменную value и инициализируйте ее любым значением.
     *  Если value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение “Красный”,
     *  если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно),
     *  то “Желтый”, если больше 100 (100 исключительно) - “Зеленый”;
     */
    public static void printColor(){
        int value = 1;
        if(value <= 0){
            System.out.println("Красный");
        } else if (value > 100){
            logger.info("Зеленый");
        } else {
            logger.info("Желтый");
        }
    }

    /**
     * 4. Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b,
     *  и инициализируйте их любыми значениями, которыми захотите. Если a больше или равно b,
     *  то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;
     */
    public static void compareNumbers(){
        int a = 1;
        int b = 1;
        if (a >= b)
            logger.info("a >= b");
        else
            logger.info("a < b");
    }

    /**
     * 5. Напишите метод, принимающий на вход два целых числа и проверяющий,
     *  что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
     */
    public static boolean checkRangeTenToTwenty(int n1, int n2){
        return (n1 + n2) >= 10 && (n1 + n2) <= 20;
    }

    /**
     * 6. Напишите метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
     *  положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
     */
    public static void checkNumber(int number){
        if(number >= 0)
            logger.info("positive");
        else
            logger.info("negative");
    }

    /**
     * 7. Напишите метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
     *  если число отрицательное, и вернуть false если положительное.
     */
    public static boolean isNegative(int number){
        return number < 0;
    }

    /**
     * 8. Напишите метод, которому в качестве аргументов передается строка и число,
     *  метод должен отпечатать в консоль указанную строку, указанное количество раз;
     */
    public static void printStrings(int number, String str){
        if(number <= 0)
            logger.info("Incorrect number, number must be > 0");
        else {
            while (number > 0){
                logger.info(str);
                number--;
            }
        }
    }

    /**
     * 9. Напишите метод, который определяет, является ли год високосным,
     *  и возвращает boolean (високосный - true, не високосный - false). Каждый 4-й год является високосным,
     *  кроме каждого 100-го, при этом каждый 400-й – високосный.
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * 10. Задать целочисленный массив, состоящий из элементов 0 и 1.
     *  Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
    public static int[] changeValues(int[] arr){

        for(int i = 0, j = arr.length-1; i < arr.length/2; i++, j--){
            arr[i] = swap(arr[i]);
            arr[j] = swap(arr[j]);
        }

        arr[arr.length / 2] = (arr.length % 2 != 0) ? swap(arr[arr.length / 2]) : arr[arr.length / 2];

        return arr.clone();
    }
    private static int swap(int n){
        return n == 0 ? 1 : 0;
    }

    /**
     * 11. Задать пустой целочисленный массив длиной 100.
     * С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100;
     */
    public static int[] fillArray(){
        int[] arr = new int[100];

       /*for(int i = 0; i < arr.length; i++){
           arr[i] = i+1;
       }*/
        //так будет хутчэй
        for(int i = 0, j = arr.length-1; i <= j; i++, j--){
            arr[i] = i+1;
            arr[j] = j+1;
        }

        return arr.clone();
    }

    /**
     * 12. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
     */
    public static int[] multiNumberLessSix(){
        int[] arr = new int[]{ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };

        for(int i = 0; i < arr.length; i++){
            arr[i] = arr[i] < 6 ? arr[i] * 2 : arr[i];
        }

        return arr.clone();
    }

    /**
     * 13. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
     *  и с помощью цикла(-ов) заполнить его диагональные элементы единицами
     *  (можно только одну из диагоналей, если обе сложно).
     *  Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны,
     *  то есть [0][0], [1][1], [2][2], ..., [n][n];
     */
    public static int[][] fillDiagonals(int size){
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
            matrix[i][size - 1 - i] = 1;
        }

        return matrix.clone();
    }

    /**
     * 14. Написать метод, принимающий на вход два аргумента: len и initialValue,
     *  и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue.
     */
    public static int[] initialArr(int len, int initialValue){
        int[] arr = new int[len];

        for (int i = 0; i < len; i++){
            arr[i] = initialValue;
        }

        return arr.clone();
    }
}
