package com.company.sales.web.product;

import com.company.sales.entity.Product;
import com.haulmont.cuba.gui.screen.*;

@UiController("sales$Product.edit")
@UiDescriptor("product-edit.xml")
@EditedEntityContainer("productDc")
@LoadDataBeforeShow
public class ProductEdit extends StandardEditor<Product> {
}