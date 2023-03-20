package org.example;

public class RoundingModes {

    public static void main(String[] args) {
        // don't do this

        int truncated = (int) 4.6;
        System.out.println(truncated); // 4

        // rather than use Math - it is more readable
        System.out.println(Math.ceil(4.1)); // 5.0
        System.out.println(Math.floor(4.9)); // 4.0

        System.out.println(Math.round(4.5)); // 5
        System.out.println(Math.round(4.4)); // 4
    }
}
