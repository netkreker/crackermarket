package com.crackermarket.app.services;

import com.crackermarket.app.entities.Address;
import com.crackermarket.app.entities.Seller;
import org.hibernate.Hibernate;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

@Component
public class SellerDAO {

    @Autowired
    private EntityManager entityManager;

    public Seller findSellerById(UUID id) {
        entityManager.getTransaction().begin();
        Seller user = entityManager.find(Seller.class, id);
        entityManager.getTransaction().commit();
        return user;
    }
    public void saveSeller(Seller user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    public List<Seller> findSellersByName(String name) {
        List<Seller> users = null;
        entityManager.getTransaction().begin();
        users = entityManager.createQuery("SELECT u FROM Seller u WHERE u.name = :name")
                .setParameter("name", name).getResultList();
        entityManager.getTransaction().commit();
        return users;
    }

    public List<Seller> findAllSellers(){
        List<Seller> users = null;
        entityManager.getTransaction().begin();
        users = entityManager.createQuery("SELECT u FROM Seller u").getResultList();
        entityManager.getTransaction().commit();
        return users;
    }

    public List<Seller> findSellersBySurname(String surname){
        List<Seller> users = null;
        entityManager.getTransaction().begin();
        users = entityManager.createQuery("SELECT u FROM Seller u WHERE u.surname =:surname").setParameter("surname", surname).getResultList();
        entityManager.getTransaction().commit();
        return users;
    }

    public List<Seller> findSellersByEmail(String email){
        List<Seller> users = null;
        entityManager.getTransaction().begin();
        users = entityManager.createQuery("SELECT u FROM Seller u WHERE u.email =:email").setParameter("email", email).getResultList();
        entityManager.getTransaction().commit();
        return users;
    }

    public List<Seller> findSellersByPhoneNumber(String phoneNumber){
        List<Seller> users = null;
        entityManager.getTransaction().begin();
        users = entityManager.createQuery("SELECT u FROM Seller u WHERE u.phoneNumber =:phonenumber").setParameter("phonenumber", phoneNumber).getResultList();
        entityManager.getTransaction().commit();
        return users;
    }

    public List<Seller> findCustomersByAddress(Address address){
        List<Seller> users = null;
        entityManager.getTransaction().begin();
        users = entityManager.createQuery("SELECT u FROM Seller u WHERE id =:user_id").setParameter("user_id", address.getUser().getId()).getResultList();
        entityManager.getTransaction().commit();
        return users;
    }

}
