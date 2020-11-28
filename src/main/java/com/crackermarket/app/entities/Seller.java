package com.crackermarket.app.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SELLER")
public class Seller extends User {

    public Product createProduct(){
        return new Product();
    }

    public Boolean removeProduct(){
        return false;
    }
}
