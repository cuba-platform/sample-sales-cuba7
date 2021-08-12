package com.company.sales.service;

import com.company.sales.entity.Order;

import java.math.BigDecimal;
import java.util.Date;

public interface OrderService {
    String NAME = "sales_OrderService";

    public BigDecimal calculatePrice(String orderNumber);

    public OrderValidationResult validateOrder(Order order, Date validationDate);
}