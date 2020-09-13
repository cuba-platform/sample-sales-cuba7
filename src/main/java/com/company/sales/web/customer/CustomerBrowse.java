package com.company.sales.web.customer;

import com.haulmont.cuba.gui.screen.LoadDataBeforeShow;
import io.jmix.ui.screen.*;
import com.company.sales.entity.Customer;

@UiController("sales_Customer.browse")
@UiDescriptor("customer-browse.xml")
@LookupComponent("customersTable")
@LoadDataBeforeShow
public class CustomerBrowse extends StandardLookup<Customer> {
}