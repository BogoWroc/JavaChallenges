package org.example.anonymous;

import java.util.Comparator;
import java.util.List;

public class Anonymous {

    void sortProductsByName(List<Product> products) {
        // Add your solution here
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.name().compareTo(o2.name());
            }
        });
    }
}

record Product(long id, String name, String description) {
}
