package com.company.sales.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@NamePattern("%s|name")
@Table(name = "SALES_PRODUCT")
@Entity(name = "sales_Product")
public class Product extends StandardEntity {
    private static final long serialVersionUID = 5550142551079178888L;

    @Column(name = "NAME", nullable = false, length = 50)
    protected String name;

    @Column(name = "PRICE", nullable = false)
    protected BigDecimal price;

    @Column(name = "SPECIAL")
    protected Boolean special;

    public Boolean getSpecial() {
        return special;
    }

    public void setSpecial(Boolean special) {
        this.special = special;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }


}