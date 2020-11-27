package com.crackermarket.app.services;

import com.crackermarket.app.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;

@Component
public class CategoryDAO {
    @Autowired
    private EntityManager entityManager;

    public Category findCategoryById(UUID id) {
        entityManager.getTransaction().begin();
        Category category = entityManager.find(Category.class, id);
        entityManager.getTransaction().commit();
        return category;
    }
    public void saveCategory(Category category) {
        entityManager.getTransaction().begin();
        entityManager.persist(category);
        entityManager.getTransaction().commit();
    }
    
    public List<Category> findCategoryByName(String name) {
        List<Category> categories = null;
        entityManager.getTransaction().begin();
        categories = entityManager.createQuery("SELECT c FROM Category c WHERE c.name = :name")
                .setParameter("name", name).getResultList();
        entityManager.getTransaction().commit();
        return categories;
    }
    public List<Category> findAllCategories(){
        List<Category> categories = null;
        entityManager.getTransaction().begin();
        categories = entityManager.createQuery("SELECT c FROM Category c").getResultList();
        entityManager.getTransaction().commit();
        return categories;
    }
}
