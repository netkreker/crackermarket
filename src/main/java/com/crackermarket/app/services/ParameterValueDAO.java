package com.crackermarket.app.services;

import com.crackermarket.app.entities.ParameterValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class ParameterValueDAO {

    @Autowired
    EntityManager entityManager;

    public void saveParameterValue(ParameterValue parameter) {
        entityManager.getTransaction().begin();
        entityManager.persist(parameter);
        entityManager.getTransaction().commit();
    }
}
