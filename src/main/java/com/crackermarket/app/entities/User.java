package com.crackermarket.app.entities;

import com.crackermarket.app.core.BaseEntity;

import javax.persistence.*;
import java.util.Set;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User extends BaseEntity {

    @Column(name = "USER_NAME")
    protected String userName;

    @Column(name = "PASSWORD")
    protected String password;

    @Column(name = "SURNAME")
    protected String surname;

    @Column(name = "EMAIL")
    protected String email;

    @Column(name = "PHONE_NUMBER")
    protected String phoneNumber;

    @OneToMany(mappedBy = "user")
    protected Set<Address> addresses;

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public Set<Address> getAddresses() { return addresses; }

    public void setAddresses(Set<Address> addresses) { this.addresses = addresses; }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}
