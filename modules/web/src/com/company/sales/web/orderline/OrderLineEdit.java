package com.company.sales.web.orderline;

import com.company.sales.entity.OrderLine;
import com.haulmont.cuba.gui.screen.*;

@UiController("sales$OrderLine.edit")
@UiDescriptor("order-line-edit.xml")
@EditedEntityContainer("orderLineDc")
public class OrderLineEdit extends StandardEditor<OrderLine> {
}