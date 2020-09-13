package com.company.sales.web.product;

import com.haulmont.cuba.gui.screen.*;
import com.company.sales.entity.Product;


@UiController("sales_Product.browse")
@UiDescriptor("product-browse.xml")
@LookupComponent("productsTable")
@LoadDataBeforeShow
public class ProductBrowse extends StandardLookup<Product> {
}