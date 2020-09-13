package com.company.sales.listener;

import com.company.sales.entity.Order;
import com.company.sales.entity.OrderLine;
import com.haulmont.cuba.core.TransactionalDataManager;
import com.haulmont.cuba.core.app.events.EntityChangedEvent;
import com.haulmont.cuba.core.entity.contracts.Id;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.UUID;

@Component("sales_OrderLineChangedListener")
public class OrderLineChangedListener {

    @Inject
    private TransactionalDataManager txDm;

    @EventListener
    private void beforeCommit(EntityChangedEvent<OrderLine, UUID> event) {
        Order order;
        if (event.getType() != EntityChangedEvent.Type.DELETED) {
            order = txDm.load(event.getEntityId())
                    .view("orderLine-with-order")
                    .one()
                    .getOrder();
        } else {
            Id<Order, UUID> orderId = event.getChanges().getOldReferenceId("order");
            order = txDm.load(orderId).optional().orElse(null);
            if (order == null) {
                // the order could be deleted too
                return;
            }
        }

        long count = txDm.load(OrderLine.class)
                .query("select o from sales_OrderLine o where o.order = :order")
                .parameter("order", order)
                .view("orderLine-with-product")
                .list().stream()
                .filter(orderLine -> Boolean.TRUE.equals(orderLine.getProduct().getSpecial()))
                .count();

        order.setNumberOfSpecialProducts((int) count);

        txDm.save(order);
    }
}