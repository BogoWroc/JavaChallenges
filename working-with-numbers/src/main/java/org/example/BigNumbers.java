package org.example;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigNumbers {

    public static void main(String[] args) {
        int maxInt = Integer.MAX_VALUE;
        long maxLong = Long.MAX_VALUE;

        // what if we have a huge numbers, then use
        BigInteger bi = new BigInteger("999999999999999999999999999999999999999999999999999999");
        BigDecimal bd = new BigDecimal("55555555555555555555555555555555555555555555555555555555.54444444444444444444444");
    }
}
