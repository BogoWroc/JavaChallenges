package org.example.nested;

public class StaticNestedClazz {

    private static String getMessageStatic() {
        return "Hello from a static method in the enclosing class";
    }

    private String getMessageInstance() {
        return "Hello from an instance method in the enclosing class";
    }

    // Add your solution here
    public static class Nested {
        public static void run(){
            System.out.println(getMessageStatic());

        }
    }
}
