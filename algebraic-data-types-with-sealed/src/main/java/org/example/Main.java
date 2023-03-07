package org.example;

import org.example.model.DiscountOrderLine;
import org.example.model.OrderLine;
import org.example.model.SaleOrderLine;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderLine o1 = new SaleOrderLine("Apple", 1, new BigDecimal(5));
        OrderLine o2 = new DiscountOrderLine("MAR2023", new BigDecimal(2));
        var orderLines = List.of(o1, o2);

        var total = new OrderService().calculateTotalAmount(orderLines);

        // Truthy
        System.out.println(total.intValue() == 3);
    }
}