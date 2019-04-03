package com.company.sales.web.order;

import com.company.sales.entity.OrderLine;
import com.haulmont.cuba.gui.model.CollectionChangeType;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.sales.entity.Order;

import javax.inject.Inject;
import java.math.BigDecimal;

@UiController("sales_Order.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
@LoadDataBeforeShow
public class OrderEdit extends StandardEditor<Order> {

    @Inject
    private CollectionContainer<OrderLine> linesDc;

    @Subscribe(id = "linesDc", target = Target.DATA_CONTAINER)
    protected void onOrderLinesDcCollectionChange(CollectionContainer.CollectionChangeEvent<OrderLine> event) {
        if (event.getChangeType() != CollectionChangeType.REFRESH) {
            calculateAmount();
        }
    }

    protected void calculateAmount() {
        BigDecimal amount = BigDecimal.ZERO;
        for (OrderLine line : linesDc.getItems()) {
            amount = amount.add(line.getProduct().getPrice().multiply(line.getQuantity()));
        }
        getEditedEntity().setAmount(amount);
    }
}