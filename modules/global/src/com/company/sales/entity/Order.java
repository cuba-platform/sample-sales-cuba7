package com.company.sales.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@NamePattern("%s %s|date,customer")
@Table(name = "SALES_ORDER")
@Entity(name = "sales_Order")
public class Order extends StandardEntity {
    private static final long serialVersionUID = 5602880376063487368L;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_", nullable = false)
    protected Date date;

    @Column(name = "NUMBER_")
    private String number;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "order")
    protected List<OrderLine> lines;

    @Column(name = "AMOUNT")
    protected BigDecimal amount;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    protected Customer customer;

    @Column(name = "NUMBER_OF_SPECIAL_PRODUCTS")
    protected Integer numberOfSpecialProducts;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getNumberOfSpecialProducts() {
        return numberOfSpecialProducts;
    }

    public void setNumberOfSpecialProducts(Integer numberOfSpecialProducts) {
        this.numberOfSpecialProducts = numberOfSpecialProducts;
    }

    public void setLines(List<OrderLine> lines) {
        this.lines = lines;
    }

    public List<OrderLine> getLines() {
        return lines;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }


}