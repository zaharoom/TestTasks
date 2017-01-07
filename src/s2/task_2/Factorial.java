package s2.task_2;

import java.math.BigInteger;

/**
 * Напишите метод вычисления факториала целого числа без использования циклических конструкций
 * типа: for, while, do-while ...
 */

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(10));
    }

    /**
     * Method calculates factorial from received value
     *
     * @param num number to calculate
     * @return factorial of received number
     */
    public static BigInteger factorial(int num) {
        BigInteger result;

        if (num == 0) return BigInteger.ONE;
        if (num < 0) return BigInteger.ZERO;

        result = factorial(num - 1).multiply(BigInteger.valueOf(num));

        return result;
    }
}
