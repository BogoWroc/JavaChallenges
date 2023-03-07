package org.example.model;

import java.math.BigDecimal;

public record SaleOrderLine(String name, int quantity, BigDecimal amount) implements OrderLine {
}
