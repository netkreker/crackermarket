package com.crackermarket.app.services;

import com.crackermarket.app.entities.Category;
import com.crackermarket.app.entities.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

@Component
public class ParameterDao {
    @Autowired
    private EntityManager entityManager;

    public Category findParameterById(UUID id) {
        entityManager.getTransaction().begin();
        Category category = entityManager.find(Category.class, id);
        entityManager.getTransaction().commit();
        return category;
    }
    public void saveParameter(Parameter parameter) {
        entityManager.getTransaction().begin();
        entityManager.persist(parameter);
        entityManager.getTransaction().commit();
    }
    public List<Parameter> parameters() {
        entityManager.getTransaction().begin();
        List <Parameter> parameters = entityManager.createQuery("SELECT p FROM Parameter p").getResultList();
        entityManager.getTransaction().commit();
        return parameters;
    }
}
