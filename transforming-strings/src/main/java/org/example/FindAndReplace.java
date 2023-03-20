package org.example;

public class FindAndReplace {

    public static void main(String[] args) {
        findMatches();
        replace();
    }

    private static void findMatches() {
        var text = "Java 17 tasks!";

        System.out.println(text.matches("Java 17 tasks!")); // true, because it is exact match
        System.out.println(text.matches("Java 17")); // false, because it is NOT exact match

        System.out.println(text.matches("[Jj]ava.*")); // true, regex is used
        System.out.println(text.matches("Java [0-9]+ tasks!")); // true, regex is used
    }

    private static void replace() {
        var text =  "Java 17 or 11 tasks!";

        System.out.println(text.replace("17", "10")); // replace all, but it takes a char sequence
        System.out.println(text.replaceAll("17", "10")); // replace all, but it takes a regex
    }
}
