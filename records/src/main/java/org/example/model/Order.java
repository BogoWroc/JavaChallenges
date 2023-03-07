package org.example.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public record Order(long id, Customer customer, LocalDateTime dateTime, List<OrderLine> lines) {
    public Order {
        lines = List.copyOf(lines);
    }

    // wither methods are used if we would like to make a copy an instance with some small modification
    public Order withLine(OrderLine orderLine) {
        var newOrderLines = new ArrayList<>(this.lines);
        newOrderLines.add(orderLine);
        return new Order(id, customer, dateTime, newOrderLines);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private long id;
        private Customer customer;
        private LocalDateTime dateTime;
        private List<OrderLine> orderLines = new ArrayList<>();

        public Builder withId(long id) {
            this.id = id;
            return this;
        }

        public Builder forCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder atDateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public Builder addLine(OrderLine orderLine) {
            this.orderLines.add(orderLine);
            return this;
        }

        public Order build() {
            return new Order(this.id, this.customer, this.dateTime, this.orderLines);
        }
    }
}
