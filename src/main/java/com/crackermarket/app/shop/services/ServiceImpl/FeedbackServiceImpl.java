package com.crackermarket.app.shop.services.ServiceImpl;
import com.crackermarket.app.shop.repository.FeedbackDAO;
import com.crackermarket.app.shop.services.FeedbackService;
import com.crackermarket.app.shop.entities.user.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private FeedbackDAO feedbackDAO;

    @Autowired
    public FeedbackServiceImpl(FeedbackDAO feedbackDAO) {
        this.feedbackDAO = feedbackDAO;
    }

    public FeedbackServiceImpl() { }

    @Override
    public Feedback findFeedbackById(UUID id) {
        return feedbackDAO.findFeedbackById(id);
    }

    @Override
    public List<Feedback> findAllFeedbacks() {
        return feedbackDAO.findAllFeedbacks();
    }

    @Override
    public List<Feedback> findAllUserFeedbacks(UUID user_id) {
        return feedbackDAO.findAllUserFeedbacks(user_id);
    }

    @Override
    public List<Feedback> findAllProductFeedbacks(UUID product_id) {
        return feedbackDAO.findAllProductFeedbacks(product_id);
    }

    @Override
    public void saveFeedback(Feedback feedback) {
        feedbackDAO.saveFeedback(feedback);
    }

    @Override
    public void updateFeedback(Feedback feedback) {
        feedbackDAO.updateFeedback(feedback);
    }

    @Override
    public void deleteFeedback(Feedback feedback) {
        feedbackDAO.deleteFeedback(feedback);
    }
}
