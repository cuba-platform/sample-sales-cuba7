package com.company.sales.web.product;

import com.haulmont.cuba.gui.screen.*;
import com.company.sales.entity.Product;


@UiController("sales_Product.edit")
@UiDescriptor("product-edit.xml")
@EditedEntityContainer("productDc")
@LoadDataBeforeShow
public class ProductEdit extends StandardEditor<Product> {
}