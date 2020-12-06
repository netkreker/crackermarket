package com.crackermarket.app.services;

import com.crackermarket.app.user.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

@Component
public class AddressDAO {

    @Autowired
    private EntityManager entityManager;

    public Address findAddressById(UUID id) {
        entityManager.getTransaction().begin();
        Address address = entityManager.find(Address.class, id);
        entityManager.getTransaction().commit();
        return address;
    }
    public void saveAddress(Address address) {
        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();
    }

    public List<Address> findAllAddresses(){
        List<Address> addresses = null;
        entityManager.getTransaction().begin();
        addresses = entityManager.createQuery("SELECT a FROM Address a").getResultList();
        entityManager.getTransaction().commit();
        return addresses;
    }

    public List<Address> findAddressesByPostalCode(String postalcode) {
        List<Address> addresses = null;
        entityManager.getTransaction().begin();
        addresses = entityManager.createQuery("SELECT a FROM Address a WHERE a.postalCode = :postalcode")
                .setParameter("postalcode", postalcode).getResultList();
        entityManager.getTransaction().commit();
        return addresses;
    }

    public List<Address> findAddressesByCountry(String country) {
        List<Address> addresses = null;
        entityManager.getTransaction().begin();
        addresses = entityManager.createQuery("SELECT a FROM Address a WHERE a.country = :country")
                .setParameter("country", country).getResultList();
        entityManager.getTransaction().commit();
        return addresses;
    }

    public List<Address> findAddressesByStreet(String street) {
        List<Address> addresses = null;
        entityManager.getTransaction().begin();
        addresses = entityManager.createQuery("SELECT a FROM Address a WHERE a.street = :street")
                .setParameter("street", street).getResultList();
        entityManager.getTransaction().commit();
        return addresses;
    }

    public List<Address> findAddressesByCity(String city) {
        List<Address> addresses = null;
        entityManager.getTransaction().begin();
        addresses = entityManager.createQuery("SELECT a FROM Address a WHERE a.city = :city")
                .setParameter("city", city).getResultList();
        entityManager.getTransaction().commit();
        return addresses;
    }
}
