package com.example.redoy.aistasker.models;

public class MessageItem {

    String msgTaskTitle;
    String msgTime;
    String msgPreview;

    public MessageItem(String msgTaskTitle, String msgTime, String msgPreview) {
        this.msgTaskTitle = msgTaskTitle;
        this.msgTime = msgTime;
        this.msgPreview = msgPreview;
    }

    public String getMsgTaskTitle() {
        return msgTaskTitle;
    }

    public String getMsgTime() {
        return msgTime;
    }

    public String getMsgPreview() {
        return msgPreview;
    }
}
