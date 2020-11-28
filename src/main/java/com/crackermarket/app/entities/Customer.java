package com.crackermarket.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer extends User {

    public Feedback createFeedBack(){
        return new Feedback();
    }

    public Order createOrder(){
        return new Order();
    }

}
