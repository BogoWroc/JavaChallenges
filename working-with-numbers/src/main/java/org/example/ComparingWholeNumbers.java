package org.example;

public class ComparingWholeNumbers {

    public static void main(String[] args) {

        //if you compare primitives, then use ==
        System.out.println(127 == 127); // true
        System.out.println(128 == 128); // true

        // if you compare wrappers, then DO NOT use ==
        System.out.println(Integer.valueOf("127") == Integer.valueOf("127")); // true
        System.out.println(Integer.valueOf("128") == Integer.valueOf("128")); // false, because number objects are stored in number pool, but only for numbers <=127!

        // instead use EQUAL
        System.out.println(Integer.valueOf("127").equals(Integer.valueOf("127"))); // true
        System.out.println(Integer.valueOf("128").equals(Integer.valueOf("128"))); // true

    }
}
