package com.lendhand.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long feedbackId;

    private String name;
    private String email;
    private String subject;
    private String Description;

    public Feedback() {

    }

    public Feedback(Long feedbackId, String name, String email, String subject, String description) {
        this.feedbackId = feedbackId;
        this.name = name;
        this.email = email;
        this.subject = subject;
        Description = description;

    }

    public Long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "Feedback [Description=" + Description + ", email=" + email + ", feedbackId=" + feedbackId + ", name="
                + name + ", subject=" + subject + "]";
    }

}
