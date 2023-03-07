package org.example.model;

public sealed interface OrderLine permits DiscountOrderLine, SaleOrderLine {}
