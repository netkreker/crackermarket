package com.crackermarket.app.services;

import com.crackermarket.app.entities.Address;
import com.crackermarket.app.entities.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

@Component
public class AdminDAO {

    @Autowired
    private EntityManager entityManager;

    public Admin findAdminById(UUID id) {
        entityManager.getTransaction().begin();
        Admin user = entityManager.find(Admin.class, id);
        entityManager.getTransaction().commit();
        return user;
    }
    public void saveAdmin(Admin user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    public List<Admin> findAdminsByName(String name) {
        List<Admin> users = null;
        entityManager.getTransaction().begin();
        users = entityManager.createQuery("SELECT u FROM Admin u WHERE u.name = :name")
                .setParameter("name", name).getResultList();
        entityManager.getTransaction().commit();
        return users;
    }

    public List<Admin> findAllAdmins(){
        List<Admin> users = null;
        entityManager.getTransaction().begin();
        users = entityManager.createQuery("SELECT u FROM Admin u").getResultList();
        entityManager.getTransaction().commit();
        return users;
    }

    public List<Admin> findAdminsBySurname(String surname){
        List<Admin> users = null;
        entityManager.getTransaction().begin();
        users = entityManager.createQuery("SELECT u FROM Admin u WHERE u.surname =:surname").setParameter("surname", surname).getResultList();
        entityManager.getTransaction().commit();
        return users;
    }

    public List<Admin> findAdminsByEmail(String email){
        List<Admin> users = null;
        entityManager.getTransaction().begin();
        users = entityManager.createQuery("SELECT u FROM Admin u WHERE u.email =:email").setParameter("email", email).getResultList();
        entityManager.getTransaction().commit();
        return users;
    }

    public List<Admin> findAdminsByPhoneNumber(String phoneNumber){
        List<Admin> users = null;
        entityManager.getTransaction().begin();
        users = entityManager.createQuery("SELECT u FROM Admin u WHERE u.phoneNumber =:phonenumber").setParameter("phonenumber", phoneNumber).getResultList();
        entityManager.getTransaction().commit();
        return users;
    }

    public List<Admin> findAdminsByAddress(Address address){
        List<Admin> users = null;
        entityManager.getTransaction().begin();
        users = entityManager.createQuery("SELECT u FROM Admin u WHERE id =:user_id").setParameter("user_id", address.getUser().getId()).getResultList();
        entityManager.getTransaction().commit();
        return users;
    }

}
