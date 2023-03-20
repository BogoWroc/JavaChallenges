package org.example;

public class IteratingOverCharacters {

    public static void main(String[] args) {
        var text = "Ala ma kota";

        // most known approach
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
        }

        System.out.println();

        // simplest way
        for (char ch: text.toCharArray()) {
            System.out.print(ch);
        }
    }
}
