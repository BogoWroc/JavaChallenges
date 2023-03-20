package org.example;

public class ComparingStrings {

    public static void main(String[] args) {
        var s1 = "str";
        var s2 = "str";

        // True because strings are from the string pool
        System.out.println(s1 == s2); // true

        // but if we will create the new instance of string
        var s3 = new String("str");
        System.out.println(s1 == s3); // false

        // correct comparing of strings
        System.out.println(s1.equals(s3)); // true
        // or
        System.out.println(s1.equalsIgnoreCase(s3)); // true

    }
}

