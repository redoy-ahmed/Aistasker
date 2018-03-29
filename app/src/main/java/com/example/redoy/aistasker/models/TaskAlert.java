package com.example.redoy.aistasker.models;

public class TaskAlert {

    public String keyword;
    public String location;

    public TaskAlert(String keyword, String location) {
        this.keyword = keyword;
        this.location = location;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getLocation() {
        return location;
    }
}
