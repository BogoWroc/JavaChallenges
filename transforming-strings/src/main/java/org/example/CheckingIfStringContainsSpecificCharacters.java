package org.example;

import java.util.function.IntPredicate;

public class CheckingIfStringContainsSpecificCharacters {

    public static final String ONLY_DIGITS = "123456789";
    public static final String NOT_ONLY_DIGITS = "12345A67ALA";

    public static void main(String[] args) {

        System.out.println("Character.isDigit() solution:");

        System.out.println(containsOnlyDigitsLoop(ONLY_DIGITS)); // true
        System.out.println(containsOnlyDigitsLoop(NOT_ONLY_DIGITS)); // false

        System.out.println("Java 8, functional-style solution");
        System.out.println(containsOnlyDigitsFunctional(ONLY_DIGITS)); // true
        System.out.println(containsOnlyDigitsFunctional(NOT_ONLY_DIGITS)); // false

        System.out.println("Regex solution");
        System.out.println(containsOnlyDigitsRegex(ONLY_DIGITS)); // true
        System.out.println(containsOnlyDigitsRegex(NOT_ONLY_DIGITS)); // false

        // or we can use Predicates
        System.out.println(containsOnly(ONLY_DIGITS, Character::isDigit)); // true
        System.out.println(containsOnly(NOT_ONLY_DIGITS, Character::isLetterOrDigit)); // true
        System.out.println(containsOnly(NOT_ONLY_DIGITS, Character::isLetter)); // false
    }

    private static boolean containsOnlyDigitsLoop(String text) {
        var retVal = true;
        for (char ch : text.toCharArray()) {
            if (!Character.isDigit(ch)) {
                retVal = false;
                break;
            }
        }

        return retVal;
    }

    private static boolean containsOnlyDigitsFunctional(String text) {
        return text.chars().allMatch(Character::isDigit);
    }

    private static boolean containsOnly(String text, IntPredicate predicate) {
        return text.chars().allMatch(predicate);
    }

    private static boolean containsOnlyDigitsRegex(String text) {
        return text.matches("[0-9]+");
    }
}
