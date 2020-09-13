package com.company.sales.web.orderline;

import com.haulmont.cuba.gui.screen.LoadDataBeforeShow;
import io.jmix.ui.screen.*;
import com.company.sales.entity.OrderLine;

@UiController("sales_OrderLine.edit")
@UiDescriptor("order-line-edit.xml")
@EditedEntityContainer("orderLineDc")
@LoadDataBeforeShow
public class OrderLineEdit extends StandardEditor<OrderLine> {
}