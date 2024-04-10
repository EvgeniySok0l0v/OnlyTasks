package org.example;

import org.example.excption.MyArrayDataException;
import org.example.excption.MyArraySizeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try{
            logger.info(String.valueOf(sumArray(new String[][]{
                    new String[]{"1", "1", "1", "1"},
                    new String[]{"1", "1", "1", "1"},
                    new String[]{"1", "1", "1", "1"},
                    new String[]{"1", "1", "1", "1"}
            })));

        } catch (MyArrayDataException e) {
            logger.error(e.getMessage());
        } catch (MyArraySizeException e) {
            logger.error(e.getMessage());
        }
    }

    private static int sumArray(String[][] arr) throws MyArraySizeException {
        if(!checkArrays(arr)){
            throw new MyArraySizeException("Рзмерность должна быть 4х4");
        }

        List<Integer> integerList = new ArrayList<>(16);

        for (int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                try {
                    integerList.add(Integer.parseInt(arr[i][j]));
                } catch (NumberFormatException e) {
                    throw new MyArraySizeException("Не верный формат данных в ячейке [" + i + "][" + j + "]");
                }
            }

        }

        return integerList.stream().mapToInt(i -> i).sum();
    }

    private static boolean checkArrays(Object[][] arr){
        return arr.length == 4 && Arrays.stream(arr).allMatch(a -> a.length == 4);
    }
}