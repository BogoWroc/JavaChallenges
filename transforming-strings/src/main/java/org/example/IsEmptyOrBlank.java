package org.example;

public class IsEmptyOrBlank {

    public static void main(String[] args) {
        System.out.println("isEmpty?");
        System.out.println("".isEmpty()); // true

        System.out.println(" ".isEmpty()); // false
        System.out.println("\u2002".isEmpty()); // false
        System.out.println("\r".isEmpty()); // false

        System.out.println("isBlank?");
        System.out.println("".isBlank()); // true

        System.out.println(" ".isBlank()); // true
        System.out.println("\u2002".isBlank()); // true
        System.out.println("\r".isBlank()); // true

    }
}
