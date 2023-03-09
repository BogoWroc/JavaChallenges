package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class Wildcards {
    // TODO: Modify the types of the parameters of this method so that the commented out code below compiles
    public static <T> void addMatchingElements(Iterable<? extends T> src, Collection<? super T> dest, Predicate<? super T>  predicate) {
        for (T element : src) {
            if (predicate.test(element)) {
                dest.add(element);
            }
        }
    }

    interface Animal {
        LocalDate birthDate();
    }

    interface Canine extends Animal {
        default boolean isSenior() {
            return birthDate().isBefore(LocalDate.now().minusYears(10));
        }
    }

    interface Feline extends Animal {
        default boolean isSenior() {
            return birthDate().isBefore(LocalDate.now().minusYears(12));
        }
    }

    record Dog(String name, LocalDate birthDate) implements Canine {}
    record Cat(String name, LocalDate birthDate) implements Feline {}

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        var daisy = new Dog("Daisy", today.minusYears(10).minusMonths(2));
        var lucky = new Dog("Lucky", today.minusYears(3).minusMonths(5));
        var bella = new Dog("Bella", today.minusYears(11).minusDays(23));
        var dogs = List.of(daisy, lucky, bella);

        var luna = new Cat("Luna", today.minusYears(13).minusMonths(3));
        var tom = new Cat("Tom", today.minusYears(4).minusDays(18));
        var cats = List.of(luna, tom);

        // It's possible to add senior dogs to an ArrayList<Dog>
        var seniorDogs = new ArrayList<Dog>();
        addMatchingElements(dogs, seniorDogs, Canine::isSenior);

        // It's possible to add senior cats to an ArrayList<Cat>
        var seniorCats = new ArrayList<Cat>();
        addMatchingElements(cats, seniorCats, Feline::isSenior);

        // TODO: It should be possible to add senior dogs to an ArrayList<Canine>
        //  Modify the signature of the method 'addMatchingElements' so that this compiles.
        var seniorCanines = new ArrayList<Canine>();
        addMatchingElements(dogs, seniorCanines, Canine::isSenior);

        // TODO: It should be possible to add senior cats to an ArrayList<Feline>
        //  Modify the signature of the method 'addMatchingElements' so that this compiles.
        var seniorFelines = new ArrayList<Feline>();
        addMatchingElements(cats, seniorFelines, Feline::isSenior);

        // TODO: It should be possible to add both senior dogs and cats to an ArrayList<Animal>
        //  Modify the signature of the method 'addMatchingElements' so that this compiles.
        var seniorAnimals = new ArrayList<Animal>();
       addMatchingElements(dogs, seniorAnimals, Canine::isSenior);
       addMatchingElements(cats, seniorAnimals, Feline::isSenior);
    }
}
