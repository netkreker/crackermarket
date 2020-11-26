package com.crackermarket.app.entities;

import com.crackermarket.app.core.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
public class Product extends BaseEntity {
    @Column(name = "CATEGORY_ID")
    private Category category;
    @Column(name = "PRICE")
    private BigDecimal price;
    @OneToMany
    @JoinColumn(name = "PARAMETER_ID")
    private List<Parameter> parameters;
    @Column(name = "COUNT")
    private Integer count;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
