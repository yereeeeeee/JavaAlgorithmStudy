package Java_03_hw;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class baekjoon_1740_최지우 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = sc.nextBigInteger();

        BigInteger[] bin = new BigInteger[40];
        BigInteger tmp = BigInteger.ONE;
        for (int i=0; i<40; i++) {
            bin[i] = tmp;
            tmp = tmp.multiply(BigInteger.valueOf(3));
        }

        BigInteger result = BigInteger.ZERO;
        for (int i=0; i<40; i++) {
            if (n.testBit(i)) {
                result = result.add(bin[i]);
            }
        }

        System.out.println(result);
    }
}