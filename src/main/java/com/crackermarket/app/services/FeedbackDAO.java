package com.crackermarket.app.services;

import com.crackermarket.app.user.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class FeedbackDAO {

    @Autowired
    private EntityManager entityManager;

    public void saveFeedback(Feedback feedback){
        entityManager.getTransaction().begin();
        entityManager.persist(feedback);
        entityManager.getTransaction().commit();
    }


}
