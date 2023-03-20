package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class IteratingOverManyLines {

    public static void main(String[] args) {
        var text = """
                Ala ma kota
                a kto ma Ale!
                Ja nie mam kota
                ale mam psa :)
                """;

        final AtomicInteger i = new AtomicInteger(1);
        text.lines().forEach(it -> System.out.println(i.getAndIncrement() +": "+it));
    }
}
