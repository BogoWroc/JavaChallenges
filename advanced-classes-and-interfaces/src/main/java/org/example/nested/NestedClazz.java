package org.example.nested;

public class NestedClazz {
    void run() {
        // Add your solution here
        new Enclosing().new Inner().run();
    }
}

class Enclosing {

    class Inner {
        void run() {
            System.out.println("Hello from the run() method in the inner class");
        }
    }
}