package org.example.enclosing;

public class Enclosing {

    static final String MESSAGE = "Hello from the enclosing class";
    final int number = 101;

    class Inner {
        static final String MESSAGE = "Hello from the inner class";
        final int number = 202;

        void run() {
            // Access to the static fields
            System.out.println(Inner.MESSAGE);
            System.out.println(Enclosing.MESSAGE);

            // Access to the instance fields
            System.out.println(this.number);
            // Access to a shadowed variable
            System.out.println(Enclosing.this.number);
        }
    }

    public static void main(String[] args) {
        new Enclosing().new Inner().run();
    }
}
