package org.example;

import java.math.BigDecimal;

public class ComparingDecimalNumbers {

    public static void main(String[] args) {
        System.out.println(0.3 == 0.3); // true

        System.out.println(0.1 + 0.2 == 0.3); // false, because it is operation on float numbers

        // instead of using floats in arithmetic operations, use BigDecimal
        BigDecimal d1 = new BigDecimal("0.1");
        BigDecimal d2 = new BigDecimal("0.2");

        System.out.println(d1.add(d2).equals(new BigDecimal("0.3"))); // true
    }
}
