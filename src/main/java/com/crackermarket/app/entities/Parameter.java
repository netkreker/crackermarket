package com.crackermarket.app.entities;

import com.crackermarket.app.core.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "PARAMETER")
public class Parameter extends BaseEntity {
    @Column(name = "NAME", unique = true)
    private String name;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;
    @Column(name = "PARAMETER_TYPE")
    private ParameterType parameterType;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ParameterType getParameterType() {
        return parameterType;
    }

    public void setParameterType(ParameterType parameterType) {
        this.parameterType = parameterType;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
