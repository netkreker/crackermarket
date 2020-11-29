package com.crackermarket.app.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ADMIN")
public class Admin extends User {

    public Category createCategory(){
        return new Category();
    }

    public Boolean deleteCategory(){
        return false;
    }

    public Boolean setProductNewCategory(){
        return false;
    }
}
