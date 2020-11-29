package com.crackermarket.app.entities;

import com.crackermarket.app.core.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CATEGORY")
public class Category extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "PARENT_CATEGORY")
    private Category parentCategory;

    @OneToMany(mappedBy = "category")
    private Set<Parameter> parameters;

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    @Override
    public String toString() {
        return "Category { " +
                " name= " + getName() +
                " parentCategory= " + getParentCategory() +
                " id= " + getId() +
                " }";
    }
}
