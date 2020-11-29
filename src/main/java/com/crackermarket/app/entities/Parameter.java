package com.crackermarket.app.entities;

import com.crackermarket.app.core.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PARAMETER")
public class Parameter extends BaseEntity {
    @Column(name = "NAME", unique = true)
    private String name;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
    @ManyToMany
    private List<Category> category;
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

    public List<Category> getCategories() {
        return category;
    }

    public void setCategories(List<Category> categories) {
        this.category = categories;
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
