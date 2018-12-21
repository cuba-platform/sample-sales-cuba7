package com.company.sales.web.customer;

import com.company.sales.entity.Customer;
import com.haulmont.cuba.gui.screen.*;

@UiController("sales$Customer.browse")
@UiDescriptor("customer-browse.xml")
@LookupComponent("customersTable")
@LoadDataBeforeShow
public class CustomerBrowse extends StandardLookup<Customer> {
}