package com.crackermarket.app.services;

import com.crackermarket.app.entities.Address;
import com.crackermarket.app.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

@Component
public class CustomerDAO {

    @Autowired
    private EntityManager entityManager;

    public Customer findCustomerById(UUID id) {
        entityManager.getTransaction().begin();
        Customer user = entityManager.find(Customer.class, id);
        entityManager.getTransaction().commit();
        return user;
    }
    public void saveCustomer(Customer user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    public List<Customer> findCustomersByName(String name) {
        List<Customer> users = null;
        entityManager.getTransaction().begin();
        users = entityManager.createQuery("SELECT u FROM Customer u WHERE u.name = :name")
                .setParameter("name", name).getResultList();
        entityManager.getTransaction().commit();
        return users;
    }

    public List<Customer> findAllCustomers(){
        List<Customer> users = null;
        entityManager.getTransaction().begin();
        users = entityManager.createQuery("SELECT u FROM Customer u").getResultList();
        entityManager.getTransaction().commit();
        return users;
    }

    public List<Customer> findCustomersBySurname(String surname){
        List<Customer> users = null;
        entityManager.getTransaction().begin();
        users = entityManager.createQuery("SELECT u FROM Customer u WHERE u.surname =:surname").setParameter("surname", surname).getResultList();
        entityManager.getTransaction().commit();
        return users;
    }

    public List<Customer> findCustomersByEmail(String email){
        List<Customer> users = null;
        entityManager.getTransaction().begin();
        users = entityManager.createQuery("SELECT u FROM Customer u WHERE u.email =:email").setParameter("email", email).getResultList();
        entityManager.getTransaction().commit();
        return users;
    }

    public List<Customer> findCustomersByPhoneNumber(String phoneNumber){
        List<Customer> users = null;
        entityManager.getTransaction().begin();
        users = entityManager.createQuery("SELECT u FROM Customer u WHERE u.phoneNumber =:phonenumber").setParameter("phonenumber", phoneNumber).getResultList();
        entityManager.getTransaction().commit();
        return users;
    }

    public List<Customer> findCustomersByAddress(Address address){
        List<Customer> users = null;
        entityManager.getTransaction().begin();
        users = entityManager.createQuery("SELECT u FROM Customer u WHERE id =:user_id").setParameter("user_id", address.getUser().getId()).getResultList();
        entityManager.getTransaction().commit();
        return users;
    }

}
