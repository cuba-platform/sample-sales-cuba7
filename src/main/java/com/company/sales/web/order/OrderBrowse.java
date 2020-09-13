package com.company.sales.web.order;

import com.haulmont.cuba.gui.screen.*;
import com.company.sales.entity.Order;

@UiController("sales_Order.browse")
@UiDescriptor("order-browse.xml")
@LookupComponent("ordersTable")
@LoadDataBeforeShow
public class OrderBrowse extends StandardLookup<Order> {
}