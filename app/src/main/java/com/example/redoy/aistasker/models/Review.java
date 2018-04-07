package com.example.redoy.aistasker.models;

import java.io.Serializable;

public class Review implements Serializable {

    public String taskName;
    public String body;
    public String createdAt;
    public int rating;

    public Review(String taskName, String body, String createdAt, int rating) {
        this.taskName = taskName;
        this.body = body;
        this.createdAt = createdAt;
        this.rating = rating;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getBody() {
        return body;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public int getRating() {
        return rating;
    }
}
