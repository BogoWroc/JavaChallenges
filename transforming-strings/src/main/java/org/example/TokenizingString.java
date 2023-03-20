package org.example;

import java.util.Arrays;

public class TokenizingString {
    public static void main(String[] args) {
        var text = "1,2,3,4";

        String[] split = text.split(",");

        System.out.println(Arrays.toString(split));
    }
}
