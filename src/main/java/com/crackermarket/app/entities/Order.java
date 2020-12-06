package com.crackermarket.app.entities;

import com.crackermarket.app.core.BaseEntity;
import com.crackermarket.app.user.User;

import javax.persistence.*;

@Entity
@Table(name = "USER_ORDER")
public class Order extends BaseEntity {

    @Column(name = "TOTAL_PRICE")
    private Double total_price;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    // TODO: присобачить связь между продуктами и заказом

    public Boolean addProduct(){
        return true;
    }

    public Boolean removeProduct(){
        return true;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "user=" + user +
                ", total_price=" + total_price +
                '}';
    }
}
