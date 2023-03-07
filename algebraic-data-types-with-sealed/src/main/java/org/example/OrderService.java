package org.example;

import org.example.model.DiscountOrderLine;
import org.example.model.OrderLine;
import org.example.model.SaleOrderLine;

import java.math.BigDecimal;
import java.util.List;

public class OrderService {

    public BigDecimal calculateTotalAmount(List<OrderLine> orderLines) {
        var total = BigDecimal.ZERO;

        for (OrderLine orderLine : orderLines) {
            if (orderLine instanceof SaleOrderLine sale) {
                total = total.add(sale.amount());
            } else if (orderLine instanceof DiscountOrderLine discount) {
                total = total.subtract(discount.amount());
            }
        }

        return total;
    }
}
