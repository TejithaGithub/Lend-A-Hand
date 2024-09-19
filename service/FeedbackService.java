package com.lendhand.service;

import java.util.List;

import com.lendhand.model.Feedback;

public interface FeedbackService {

    Feedback addFeedback(Feedback feedback);

    Feedback updateFeedback(Feedback feedback);

    List<Feedback> getAllFeedback();

    Feedback getFeedbackById(String id);

}
