package com.crackermarket.app.shop.services;

import com.crackermarket.app.shop.entities.user.Address;
import com.crackermarket.app.shop.entities.user.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    // Search
    User findUserById(UUID id);
    User findUserByUserName(String userName);
    List<User> findUsersByName(String name);
    List<User> findAllUsers();
    List<User> findUsersBySurname(String surname);
    List<User> findUsersByEmail(String email);
    List<User> findUsersByPhoneNumber(String phoneNumber);
    List<User> findCustomersByAddress(Address address);

    // Updating table
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(User user);

}
