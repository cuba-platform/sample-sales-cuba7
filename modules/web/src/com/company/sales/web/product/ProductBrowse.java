package com.company.sales.web.product;

import com.company.sales.entity.Product;
import com.haulmont.cuba.gui.screen.*;

@UiController("sales$Product.browse")
@UiDescriptor("product-browse.xml")
@LookupComponent("productsTable")
@LoadDataBeforeShow
public class ProductBrowse extends StandardLookup<Product> {


}