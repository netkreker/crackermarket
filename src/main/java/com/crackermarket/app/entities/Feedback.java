package com.crackermarket.app.entities;

import com.crackermarket.app.core.BaseEntity;
import com.crackermarket.app.enumerations.Rate;

import javax.persistence.*;

@Entity
@Table(name = "FEEDBACK")
public class Feedback extends BaseEntity {


    private Rate rate;

    @Column(name = "RECORD")
    private String record;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Column(name = "RATE")
    public String getRate() {
        if (rate == Rate.GREAT)
            return "great";
        if (rate == Rate.GOOD)
            return "good";
        if (rate == Rate.SATISFACTORILY)
            return "satisfactorily";
        if (rate == Rate.BAD)
            return "bad";
        if (rate == Rate.VERY_BAD)
            return "very bad";
        return "none";
    }

    public void setRate(String rate) {
        switch (rate) {
            case "great":
                this.rate = Rate.GREAT;
                break;
            case "good":
                this.rate = Rate.GOOD;
                break;
            case "satisfactorily":
                this.rate = Rate.SATISFACTORILY;
                break;
            case "bad":
                this.rate = Rate.BAD;
                break;
            case "very bad":
                this.rate = Rate.VERY_BAD;
                break;
            default:
                this.rate = Rate.NONE;
                break;
        }
    }

    public String getRecord() { return record; }

    public void setRecord(String record) { this.record = record; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

}
