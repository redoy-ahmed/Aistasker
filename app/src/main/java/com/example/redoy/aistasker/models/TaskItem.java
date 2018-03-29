package com.example.redoy.aistasker.models;

public class TaskItem {

    String taskTitle;
    String taskLocation;
    String taskDeadline;
    String taskRequirements;
    String taskState;
    String additionalInformation;
    String price;

    public TaskItem(String taskTitle, String taskLocation, String taskDeadline, String taskRequirements, String taskState, String additionalInformation, String price) {
        this.taskTitle = taskTitle;
        this.taskLocation = taskLocation;
        this.taskDeadline = taskDeadline;
        this.taskRequirements = taskRequirements;
        this.taskState = taskState;
        this.additionalInformation = additionalInformation;
        this.price = price;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public String getTaskLocation() {
        return taskLocation;
    }

    public String getTaskDeadline() {
        return taskDeadline;
    }

    public String getTaskRequirements() {
        return taskRequirements;
    }

    public String getTaskState() {
        return taskState;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public String getPrice() {
        return price;
    }
}
