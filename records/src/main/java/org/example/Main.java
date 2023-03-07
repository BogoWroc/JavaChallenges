package org.example;

import org.example.model.Customer;
import org.example.model.Order;
import org.example.model.OrderLine;
import org.example.model.Product;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var appleProduct = new Product(1L, "Apple", "Tasty");
        var orangeProduct = new Product(2L, "Orange");
        var bananaProduct = new Product(3L, "Banana");

        var customer = new Customer(1L, "Bob Kowalsky", "bob.kowalsky@skyy.org");

        // not readable it can be rewritten using builder pattern to improve readability
        var order1 = new Order(1L, customer, LocalDateTime.now(), List.of(
                new OrderLine(appleProduct, 3),
                new OrderLine(orangeProduct, 4)
        ));

        // more readable with the builder pattern
        var order2 = Order.builder()
                .withId(1L)
                .forCustomer(customer)
                .atDateTime(LocalDateTime.now())
                .addLine(new OrderLine(appleProduct, 3))
                .addLine(new OrderLine(orangeProduct, 4))
                .build();

        // usage of wither method -> we would like to use order2 as a base for other order instances
        var order3 = order2.withLine(new OrderLine(bananaProduct, 1));

        // Truthy
        System.out.println(order2.lines().size() == 2);
        System.out.println(order3.lines().size() == 3);

    }
}