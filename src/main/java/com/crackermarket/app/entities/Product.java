package com.crackermarket.app.entities;

import com.crackermarket.app.core.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product extends BaseEntity {
    @Column(name = "CATEGORY_ID")
    private Category category;
    
}
