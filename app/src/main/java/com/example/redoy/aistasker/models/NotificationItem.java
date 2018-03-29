package com.example.redoy.aistasker.models;

public class NotificationItem {

    public String date;
    public String title;

    public NotificationItem(String title, String date) {
        this.date = date;
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }
}
