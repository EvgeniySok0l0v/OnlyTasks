package org.example;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        System.out.println(factorial(300));

    }

    public static BigInteger factorial(Number n){
        long intValue = n.longValue();
        if(intValue < 0){
            throw new IllegalArgumentException("Отрицательное число");
        }
        if(intValue == 0 || intValue == 1){
            return BigInteger.ONE;
        }
        BigInteger f = BigInteger.ONE;

        while (intValue != 0){
            f = f.multiply(BigInteger.valueOf(intValue--));
        }

        return f;
    }
}