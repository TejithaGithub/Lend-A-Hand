package com.lendhand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lendhand.model.Feedback;
import com.lendhand.service.FeedbackService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/feedback")
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @PostMapping("/")
    public Feedback addFeedback(@RequestBody Feedback feedback) {
        return feedbackService.addFeedback(feedback);
    }

    @PutMapping("/")
    public Feedback updateFeedback(@RequestBody Feedback feedback) {
        return feedbackService.updateFeedback(feedback);
    }

    @GetMapping("/")
    public List<Feedback> getAllFeedback() {
        return feedbackService.getAllFeedback();
    }

    @GetMapping("/{id}")
    public Feedback getFeedbackById(@PathVariable String id) {
        return feedbackService.getFeedbackById(id);
    }

}
