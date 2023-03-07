package org.example.model;

interface Identifier{
    long id();
}

// The record can implement interfaces, but not to extend other classes
public record Product(long id, String name, String description) implements Identifier{

    // The compiler translate this to final class with private final fields

    // The compiler generates a constructor that initialized the fields

    // The compiler generates accessor methods: id(), name(), description()

    // Instance variable are not allowed
    // private int i;

    // It is possible to add static fields
    private static int VALUE = 23;

    // It is possible to add additional methods
    public String someAdditionalMethod(){
        return "some data";
    }

    // It is possible to override accessor methods. Accessor methods cannot have a throws clause
    @Override
    public long id(){
        return id;
    }

    // It is possible to define "Compact constructor"
    public Product {
        checkThat(id>-1, "id must be greater than 0");
    }

    // It is possible to add additional constructor
    public Product(long id, String name){
        this(id, name, "empty");
    }

    private void checkThat(boolean isValid, String msg) {
        if (!isValid) {
            throw new IllegalArgumentException(msg);
        }
    }

}
