package org.example;

import java.math.BigInteger;

/**
 * Class for Factorial
 */
public class Factorial {

    public Factorial() {
    }

    /**
     * Method for count factorial
     *
     * @param n - input number
     * @return factorial of n
     */
    public static BigInteger factorial(long n){
        if(n < 0){
            throw new IllegalArgumentException("Отрицательное число");
        }
        if(n == 0 || n == 1){
            return BigInteger.ONE;
        }
        BigInteger f = BigInteger.ONE;

        while (n != 0){
            f = f.multiply(BigInteger.valueOf(n--));
        }

        return f;
    }
}