package com.company.sales.service;

import com.company.sales.entity.Order;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Date;

@Service(OrderService.NAME)
public class OrderServiceBean implements OrderService {

    @Inject
    private Persistence persistence;

    @Override
    public BigDecimal calculatePrice(String orderNumber) {
        BigDecimal orderPrice = null;
        try (Transaction tx = persistence.createTransaction()) {
            EntityManager em = persistence.getEntityManager();
            orderPrice = (BigDecimal) em.createQuery("select sum(oi.product.price) from sales_OrderLine oi where oi.order.number = :orderNumber")
                    .setParameter("orderNumber", orderNumber)
                    .getSingleResult();
            tx.commit();
        }

        return orderPrice;
    }

    @Override
    public OrderValidationResult validateOrder(Order order, Date validationDate) {
        OrderValidationResult result=new OrderValidationResult();
        result.setSuccess(false);
        result.setErrorMessage("Validation of order "+order.getNumber()+" failed. validationDate parameter is: "+validationDate);
        return result;
    }
}