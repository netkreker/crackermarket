package com.crackermarket.app.entities;

import com.crackermarket.app.core.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "PARAMETER")
public class Parameter extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
