package com.company.sales.web.order;

import com.company.sales.entity.Order;
import com.haulmont.cuba.gui.screen.*;

@UiController("sales$Order.browse")
@UiDescriptor("order-browse.xml")
@LookupComponent("ordersTable")
@LoadDataBeforeShow
public class OrderBrowse extends StandardLookup<Order> {
}