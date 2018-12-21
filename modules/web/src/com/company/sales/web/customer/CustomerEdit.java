package com.company.sales.web.customer;

import com.company.sales.entity.Customer;
import com.company.sales.entity.Order;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("sales$Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
public class CustomerEdit extends StandardEditor<Customer> {

    @Inject
    private CollectionLoader<Order> ordersLoader;

    @Subscribe
    protected void onBeforeShow(BeforeShowEvent event) {
        ordersLoader.setParameter("customerId", getEditedEntity().getId());
        getScreenData().loadAll();
    }
}