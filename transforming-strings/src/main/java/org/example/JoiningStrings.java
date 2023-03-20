package org.example;

import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JoiningStrings {

    public static void main(String[] args) {
        String[] data = {"1","2","3","4"};

        // String.join()
        System.out.println("{" + String.join(":", data) + "}");

        // StringJoiner class
        var sj = new StringJoiner(":","{","}");
        for (String v:data) {
            sj.add(v);
        }
        System.out.println(sj.toString());

        // Streams
        var res = Stream.of(data)
                .filter(it -> !it.isBlank())
                .collect(Collectors.joining(":"));
        System.out.println("{" + res + "}");
    }
}
