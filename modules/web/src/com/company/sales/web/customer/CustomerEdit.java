package com.company.sales.web.customer;

import com.company.sales.entity.Order;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.sales.entity.Customer;

import javax.inject.Inject;

@UiController("sales_Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
public class CustomerEdit extends StandardEditor<Customer> {

    @Inject
    private CollectionLoader<Order> ordersDl;

    @Subscribe
    protected void onBeforeShow(BeforeShowEvent event) {
        // In case of using parameters in the query, we need to remove
        // @LoadDataBeforeShow annotation and manage data loading manually
        ordersDl.setParameter("customer", getEditedEntity());
        getScreenData().loadAll();
    }
}