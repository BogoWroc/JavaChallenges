package org.example;

import org.example.Wildcards.Animal;
import org.example.Wildcards.Cat;
import org.example.Wildcards.Dog;

import java.time.LocalDate;

public class HeapPollution {
    public static void main(String[] args) {
        Dog[] dogs = new Dog[2];
        dogs[0] = new Dog("a", LocalDate.now());
        dogs[1] = new Dog("b", LocalDate.now());

        // Arrays are covariant
        Animal[] animals = dogs;
        // and this is ok at the compile time, but at the runtime it will report an error! This is a heap pollution problem in the Java./
        // In the generic it is not ok! Generics are covariant
        animals[0] = new Cat("c", LocalDate.now());

    }
}
