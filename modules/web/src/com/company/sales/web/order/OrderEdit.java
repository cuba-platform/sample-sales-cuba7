package com.company.sales.web.order;

import com.company.sales.entity.OrderLine;
import com.company.sales.entity.Order;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;
import java.math.BigDecimal;

@UiController("sales$Order.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
@LoadDataBeforeShow
public class OrderEdit extends StandardEditor<Order> {

    @Inject
    private CollectionContainer<OrderLine> linesDc;

    @Subscribe
    public void init(InitEvent initEvent) {
        linesDc.addCollectionChangeListener(e -> calculateAmount());
    }

    protected void calculateAmount() {
        BigDecimal amount = BigDecimal.ZERO;
        for (OrderLine line : linesDc.getItems()) {
            amount = amount.add(line.getProduct().getPrice().multiply(line.getQuantity()));
        }
        getEditedEntity().setAmount(amount);
    }

}