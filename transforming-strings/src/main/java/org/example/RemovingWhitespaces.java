package org.example;

public class RemovingWhitespaces {

    public static void main(String[] args) {
        // trim will remove whitespaces and \t \r, etc. , but it will not remove unicode characters
        System.out.println("hello   ".trim() + "   there".trim());

        char spaceCharacterInTheUnicode ='\u2002';
        System.out.println("\\u2002 is whitespace: "+Character.isWhitespace(spaceCharacterInTheUnicode));

        System.out.println("hello\u2002".trim()+"there".trim()); // -> hello there
        // strip() will remove unicode characters
        System.out.println("hello\u2002".strip()+"there".strip()); // -> hellothere



    }
}
