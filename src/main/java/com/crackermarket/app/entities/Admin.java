package com.crackermarket.app.entities;

import com.crackermarket.app.core.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ADMIN")
public class Admin extends BaseEntity {

    @Column(name = "USER_NAME")
    protected String userName;

    @Column(name = "PASSWORD")
    protected String password;

    @Column(name = "EMAIL")
    protected String email;

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

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
